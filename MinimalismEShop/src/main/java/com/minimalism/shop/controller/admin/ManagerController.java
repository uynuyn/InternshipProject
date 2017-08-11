package com.minimalism.shop.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.minimalism.shop.cmn.service.impl.CategoryServiceImpl;
import com.minimalism.shop.cmn.service.impl.CheckinServiceImpl;
import com.minimalism.shop.cmn.service.impl.DepartmentServiceImpl;
import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.cmn.service.impl.ProductServiceImpl;
import com.minimalism.shop.cmn.validator.ProductValidator;
import com.minimalism.shop.dto.AddGroupProductDto;
import com.minimalism.shop.entities.Category;
import com.minimalism.shop.entities.GroupProduct;
import com.minimalism.shop.entities.Order;
import com.minimalism.shop.entities.Product;

@Controller
@RequestMapping("/admins")
public class ManagerController {

	@Autowired private CheckinServiceImpl checkinService;
	
	@Autowired private CategoryServiceImpl categoryService;
		
	@Autowired private GroupProductServiceImpl groupProductService;
	
	@Autowired private ProductServiceImpl productService;
	
	@Autowired private ProductValidator productValidator;
	
	@Autowired private DepartmentServiceImpl departmentService;
	
	AddGroupProductDto productDto = new AddGroupProductDto();
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(productValidator);
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == AddGroupProductDto.class) {

			// Đăng ký để chuyển đổi giữa các đối tượng multipart thành byte[]
			dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		}
	}
	
	@RequestMapping(value = "/list-order", method = RequestMethod.GET)
	public String listOrder(Model model, HttpServletRequest request) {
		String date = request.getParameter("dateOrder");
		List<Order> listOrder = new ArrayList<>();
		if(date==null || date.equals("")){
			listOrder = checkinService.findOrderbyStatusDay();
		}else {
			Date date2 = null;
			try {
				date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				listOrder = checkinService.findOrderbyDate(date2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("listOrder", listOrder);
		return "list-order";
	}
	
	@RequestMapping(value = "/add-product-old/{id}", method = RequestMethod.GET)
	public String adminaddProductOld(Model model, HttpSession session,@PathVariable("id") int id) {
		model.addAttribute("addproductoldForm" , new AddGroupProductDto());
		GroupProduct product = groupProductService.findProductbyId(id);
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setIdCategory(product.getCategory().getId());
		
		session.setAttribute("product", product);
		return "add-product-old";
	}
	
	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public String adminaddProduct(Model model, HttpSession session) {
		model.addAttribute("addproductForm" , new AddGroupProductDto());
		List<Category> categories = categoryService.findAllList();
		
		session.setAttribute("listCategory", categories);
		return "add-product";
	}
	
	/*@RequestMapping(value = "/view-product", method = RequestMethod.GET)
	public String adminviewProduct(Model model, HttpSession session) {
		List<GroupProduct> list = groupProductService.findAllList();
		model.addAttribute("listProduct", list);
		
		return "view-product";
	}*/
	
	@RequestMapping(value = "/view-product/{departmentCode}", method = RequestMethod.GET)
	public String getAllListProduct(Model model, @PathVariable("departmentCode") String departmentCode) {
		List<Category> listCategory = departmentService.findProductbyCode(departmentCode).getCategories();
		List<GroupProduct> products = new ArrayList<>();
		for (Category category : listCategory) {
			for (GroupProduct groupProduct : category.getGroupProducts()) {
				products.add(groupProduct);
			}
		}
		model.addAttribute("listProduct", products);
		return "view-product";
	}
	
	@RequestMapping(value = "/view-product/{department}/{categoryCode}", method = RequestMethod.GET)
	public String getAllListProduct(Model model, @PathVariable("department") String departmentCode,
			@PathVariable("categoryCode") String categoryCode) {
		List<GroupProduct> listProduct = new ArrayList<>();
		if(categoryCode!=null){
			listProduct = categoryService.findProductbyCodeofCategory(categoryCode).getGroupProducts();			
		}
		model.addAttribute("listProduct", listProduct);
		return "view-product";
	}
	
	
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String adminaddProduct(Model model,HttpServletRequest request,
			@ModelAttribute("addproductForm") @Validated AddGroupProductDto addGroupProduct,
			final BindingResult result, HttpSession session) throws MalformedURLException {
		addGroupProduct.setEdit(false);
		if (result.hasErrors()) {
			
			return "add-product";
	    }

		
		String name = this.doUpload(request, model, addGroupProduct);
		GroupProduct groupProduct = new GroupProduct();
		Category category = new Category();
		category.setId(addGroupProduct.getIdCategory());
		groupProduct.setName(addGroupProduct.getName());
		groupProduct.setCategory(category);
		groupProduct.setDescription(addGroupProduct.getDescription());
		if(addGroupProduct.getSize()!=0){
			groupProduct.setSize(addGroupProduct.getSize());
		}
		groupProduct.setEndProduct(true);
		groupProduct.setImge("/resources/image/"+ name);
		groupProduct.setPrice(addGroupProduct.getPrice());
		
		groupProduct = groupProductService.save(groupProduct);
		
		
		
		int qty = addGroupProduct.getQty();
		for(int i = 0 ; i < qty ; i++){
			Product product = new Product();
			product.setGroupProduct(groupProduct);
			product.setFlag(true);
			productService.save(product);
		}
		
		return "resadmin";
	}
	
	@RequestMapping(value = "/productOld", method = RequestMethod.POST)
	public String adminaddoldProduct(Model model,HttpServletRequest request,
			@ModelAttribute("addproductoldForm") @Validated AddGroupProductDto addGroupProduct,
			final BindingResult result, HttpSession session) throws MalformedURLException {
		addGroupProduct.setEdit(true);
		addGroupProduct.setName(productDto.getName());
		addGroupProduct.setIdCategory(productDto.getIdCategory());
		addGroupProduct.setId(productDto.getId());
		if (result.hasErrors()) {
			
			return "add-product-old";
	    }

		
		String name = this.doUpload(request, model, addGroupProduct);
		int qty = addGroupProduct.getQty();
		
		List<Product> products = productService.findProductbyGroupProductandflag(addGroupProduct.getId(), false);
//		if số lượng nhập ít hơn số lượng đã có trong hệ thống thi update
		GroupProduct group = groupProductService.findProductbyId(addGroupProduct.getId());
		if(addGroupProduct.getDescription()!=null){
			group.setDescription(addGroupProduct.getDescription());			
		}
		if(addGroupProduct.getSize()!=null){
			group.setSize(addGroupProduct.getSize());
		}
		if(name!=null){
			group.setImge("/resources/image/"+ name);			
		}
		if(addGroupProduct.getPrice()!=null){
			group.setPrice(addGroupProduct.getPrice());			
		}
		if(qty<= products.size()){
			for(int i = 0 ; i < qty; i++){
				Product product = products.get(i);
				product.setFlag(true);
				productService.update(product);
			}
			groupProductService.update(group);
		}
		else {
			for(int i = 0 ; i < products.size(); i++){
				Product product = products.get(i);
				product.setFlag(true);
				productService.update(product);
			}
			qty -= products.size();
			group.setEndProduct(true);
			groupProductService.update(group);
			for(int i = 0 ; i < qty ; i++){
				Product product = new Product();
				product.setGroupProduct(group);
				product.setFlag(true);
				productService.save(product);
			}
		}		
		return "redirect:/admin";
	}
	
	private String doUpload(HttpServletRequest request, Model model, //
	           AddGroupProductDto upload) throws MalformedURLException {
	 
	 
	       // Thư mục gốc upload file.
	       String uploadRootPath = "C:/Users/thucu/Desktop/Working/InternshipProject/MinimalismEShop/src/main/webapp/resources/static/image";
	       System.out.println("uploadRootPath=" + uploadRootPath);
	       String name ="";
	       File uploadRootDir = new File(uploadRootPath);
	       //
	       // Tạo thư mục gốc upload nếu nó không tồn tại.
	       if (!uploadRootDir.exists()) {
	           uploadRootDir.mkdirs();
	       }
	       CommonsMultipartFile[] fileDatas = upload.getImage();
	       //
	       List<File> uploadedFiles = new ArrayList<>();
	       for (CommonsMultipartFile fileData : fileDatas) {
	 
	           // Tên file gốc tại Client.
	           name = fileData.getOriginalFilename();
	           System.out.println("Client File Name = " + name);
	 
	           if (name != null && name.length() > 0) {
	               try {
	                   // Tạo file tại Server.
	                   File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
	 
	                   // Luồng ghi dữ liệu vào file trên Server.
	                   BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	                   stream.write(fileData.getBytes());
	                   stream.close();
	                   //
	                   uploadedFiles.add(serverFile);
	                   System.out.println("Write file: " + serverFile);
	               } catch (Exception e) {
	                   System.out.println("Error Write file: " + name);
	               }
	           }
	       }
	       model.addAttribute("uploadedFiles", uploadedFiles);
	       return name;
	   }

	
	
	@RequestMapping(value = "/listview", method = RequestMethod.GET)
	public String adminlistview(Model model) {
		
		return "listview";
	}

	@RequestMapping(value = "/import-store", method = RequestMethod.GET)
	public String adminimportStore(Model model) {
		
		return "import-store";
	}

	@RequestMapping(value = "/add-promotion", method = RequestMethod.GET)
	public String adminaddPromotion(Model model) {
		
		return "add-promotion";
	}
	
	@RequestMapping(value = "/update-product", method = RequestMethod.GET)
	public String adminupdateProduct(Model model) {
		return "update-product";
	}
		
}
