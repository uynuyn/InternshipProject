package com.minimalism.shop.cmn.service.impl;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minimalism.shop.cmn.base.BaseServiceImpl;
import com.minimalism.shop.cmn.base.Common;
import com.minimalism.shop.cmn.repository.impl.AprioriRepositoryImpl;
import com.minimalism.shop.dto.AprioriList;
import com.minimalism.shop.dto.Luat;
import com.minimalism.shop.dto.Tuple;
import com.minimalism.shop.dto.ValueNode;
import com.minimalism.shop.entities.Involve;

@Service
public class AprioriServiceImpl extends BaseServiceImpl<AprioriList, Integer>{

	@Autowired
	private AprioriRepositoryImpl aprioriRepository;

	private List<AprioriList> result = new ArrayList<>();
	List<Tuple> c;
	Set<Tuple> l;
	List<Tuple> all;
	int d[][];// dữ liệu giao dịch
	int min_support=2;
	
	public List<AprioriList> aprioriLists(){
		return result;
	}

	public void findAllList() {
		getDatabase();
		c = new ArrayList<Tuple>();
		// chứa phần tử lập lại bao nhiêu lần của  mảng
		l = new HashSet<Tuple>();
		// chứa giá tri sau khi so min sup(biến tạm)
		all = new ArrayList<Tuple>();
		// chứa tất cả thỏa min sup
		int i, j;
		Set<Integer> candidate_set = new HashSet<Integer>();
		// không có gia tri  lập lại
		for (i = 0; i < d.length; i++) {
			for (j = 0; j < d[i].length; j++) {
				candidate_set.add(d[i][j]);
			}
		}

		Iterator<Integer> iterator = candidate_set.iterator();
		while (iterator.hasNext()) {
			Set<Integer> s = new HashSet<Integer>();
			s.add(iterator.next());
			Tuple t = new Tuple(s, count(s));
			c.add(t);
		}

		prune();
		generateFrequentItemsets();
		List<Luat> luats = TimluatKetHop(all);
		LuatKetHop(luats);

	}


	private float FindConf(Tuple lst) {
		List<Tuple> tapthuongxuyen = all;
		float sup = 0;

		for (Tuple tuple : tapthuongxuyen) {
			if (lst.itemset.equals(tuple.itemset)) {
				sup = tuple.support;
			}
		}

		return sup;
	}

	private List<Luat> TimluatKetHop(List<Tuple> luatlap) {
		List<Luat> luats = new ArrayList<Luat>();
		for (Tuple tuple : luatlap) {
			if (tuple.itemset.size() < 2) {
				continue;
			}
			int tinh = tuple.itemset.size();
			int n = 0;
			for (int g = 1; g < tinh; g++) {
				n = n + Common.tinhTohop(g, tinh);
			}

			List<List<Integer>> lsti = new ArrayList<List<Integer>>();
			for (int i = 1; i <= n; i++) {
				List<Integer> lstii = VetCan(i, n, tinh);

				lsti.add(lstii);

			}
			for (List<Integer> lstin : lsti) {
				List<ValueNode> nodes = new ArrayList<ValueNode>();
				int dem = 0;
				Set<Integer> setlist = tuple.itemset;
				List<Integer> listlist = new ArrayList<Integer>(setlist);
				for (int ii : lstin) {
					ValueNode node = new ValueNode();
					node.setValue(ii);
					node.setItem(listlist.get(dem));

					nodes.add(node);
					dem++;
					if (dem >= tinh) {
						dem = 0;
					}

				}

				Luat luat = new Luat();
				List<ValueNode> nodelist = new ArrayList<ValueNode>(nodes);
				luat.setNodes(nodelist);
				luat.setSupp(tuple.support);
				luats.add(luat);
			}

		}

		return luats;

	}

	private void LuatKetHop(List<Luat> luats) {

		for (Luat luat : luats) {
			AprioriList aprioriList = new AprioriList();
			String vetrai = "";
			String vephai = "";
			Tuple tuple = new Tuple();
			Tuple tuple2 = new Tuple();
			List<Integer> lvetrai= new ArrayList<>();
			List<Integer> lvephai = new ArrayList<>();
			for (ValueNode valueNode : luat.getNodes()) {
				if (valueNode.getValue() == 0) {
					vetrai += String.valueOf(valueNode.getItem())+" ";
					lvetrai.add(valueNode.getItem());
					tuple.itemset.add(valueNode.getItem());
					tuple2.itemset.add(valueNode.getItem());
				} else if (valueNode.getValue() == 1) {
					vephai += String.valueOf(valueNode.getItem())+" ";
					lvephai.add(valueNode.getItem());
					tuple2.itemset.add(valueNode.getItem());
				}
			}
			
			float bt = FindConf(tuple2) / FindConf(tuple);
			if (bt < 0.5) {
				continue;
			}
			aprioriList.setVetrai(lvetrai);
			aprioriList.setVephai(lvephai);
			result.add(aprioriList);

			
			
			System.out.println(vetrai + "->" + vephai + " Support : " + bt);
		}
	}

	private List<Integer> VetCan(int n, int bit_amount, int tinh) {
		List<Integer> lsti = new ArrayList<Integer>();
		List<Integer> tam = new ArrayList<Integer>();
		int number = n;
		int dem = 0;
		while (number != 0) {
			int i = number % 2;
			tam.add(i);
			number = number / 2;
			dem++;
		}
		if (dem < tinh) {
			for (int i = dem; i < tinh; i++)
				lsti.add(0);
		}
		for (int i = tam.size() - 1; i >= 0; i--) {
			lsti.add(tam.get(i));
		}
		return lsti;
	}

	/**
	 * đếm xem phần tử lập bao nhiêu lần trong dữ liệu giao dịch
	 */
	private int count(Set<Integer> s) {
		int i, k;
		int support = 0;
		int count;
		boolean containsElement;
		for (i = 0; i < d.length; i++) {
			count = 0;
			Iterator<Integer> iterator = s.iterator();
			while (iterator.hasNext()) {
				int element = iterator.next();
				containsElement = false;
				for (k = 0; k < d[i].length; k++) {// vì sp chỉ có 1 lần trong 1 giao tác nen khi dếm có dừng dòng for chuyen sang dòng khác
					if (element == d[i][k]) {
						containsElement = true;// s>2 giá tri lap lai vòng while 1 lần nữa
						count++;
						break;
					}
				}
				if (!containsElement) {
					break;
				}
			}
			if (count == s.size()) {
				support++;
			}
		}
		return support;
	}

	/**kiểm tra thỏa min_sup in giá trị
	 * 
	 */
	private void prune() {
		l.clear();
		Iterator<Tuple> iterator = c.iterator();
		while (iterator.hasNext()) {
			Tuple t = iterator.next();
			// kiểm tra phần tử đó có lớn hơn min_support không (support>2)
			if (t.support >= min_support) {
				l.add(t);
				all.add(t);
			}
		}
		System.out.println("-+- L -+-");
		for (Tuple t : l) {
			System.out.println(t.itemset + " : " + t.support);
		}
	}

	/**
	 * them element Ck
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void generateFrequentItemsets() {
		boolean toBeContinued = true;
		int element = 0;
		int size = 1;
		Set<Set> candidate_set = new HashSet<Set>();
		while (toBeContinued) {
			candidate_set.clear();
			c.clear();
			Iterator<Tuple> iterator = l.iterator();
			while (iterator.hasNext()) {
				Tuple t1 = iterator.next();
				Set<Integer> temp = t1.itemset;
				Iterator<Tuple> it2 = l.iterator();
				while (it2.hasNext()) {
					Tuple t2 = it2.next();
					Iterator<Integer> it3 = t2.itemset.iterator();
					while (it3.hasNext()) {
						try {
							element = it3.next();//giá tri phần tử
						} catch (ConcurrentModificationException e) {
							// Sometimes this Exception gets thrown, so simply
							// break in that case.
							break;
						}
						// add element vào phần từ
						temp.add(element);
						if (temp.size() != size) {
							Integer[] int_arr = temp.toArray(new Integer[0]);
							Set<Integer> temp2 = new HashSet<Integer>();
							for (Integer x : int_arr) {
								temp2.add(x);
							}
							candidate_set.add(temp2);
							temp.remove(element);
						}
					}
				}
			}
			Iterator<Set> candidate_set_iterator = candidate_set.iterator();
			// mảng giá trị Scan lan n>1
			while (candidate_set_iterator.hasNext()) {
				Set s = candidate_set_iterator.next();
				// These lines cause warnings, as the candidate_set Set stores a
				// raw set.
				c.add(new Tuple(s, count(s)));
			}
			prune();
			if (l.size() <= 1) {
				toBeContinued = false;
			}
			size++;
		}
		System.out.println("\n=+= FINAL LIST =+=");
		for (Tuple t : l) {
			System.out.println(t.itemset + " : " + t.support);
		}
	}


	private int[][] getDatabase() {
		List<Involve> involves = aprioriRepository.findAllList();
		Map<Integer, List<Integer>> maps = new HashMap<Integer, List<Integer>>();
		List<Integer> temp;
		for (Involve involve : involves) {
			int list_no = involve.getIdType();
			int object = involve.getIdInvolve();
			temp = maps.get(list_no);
			if (temp == null) {
				temp = new ArrayList<Integer>();
			}
			temp.add(object);
			maps.put(list_no, temp);
		}
		// bao nhieu hóa don
		Set<Integer> keyset = maps.keySet();
		d = new int[keyset.size()][];
		Iterator<Integer> iterator = keyset.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			temp = maps.get(iterator.next());
			Integer[] int_arr = temp.toArray(new Integer[0]);
			d[count] = new int[int_arr.length];
			for (int i = 0; i < d[count].length; i++) {
				d[count][i] = int_arr[i].intValue();
			}
			count++;
		}
		return d;
	}
}
