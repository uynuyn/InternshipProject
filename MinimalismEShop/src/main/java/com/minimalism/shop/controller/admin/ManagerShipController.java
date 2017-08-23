package com.minimalism.shop.controller.admin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.CheckinServiceImpl;
import com.minimalism.shop.cmn.service.impl.UserServiceImpl;
import com.minimalism.shop.dto.OrderProduct;
import com.minimalism.shop.dto.ProductDto;
import com.minimalism.shop.entities.Order;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

@Controller
@RequestMapping("/admins")
public class ManagerShipController {
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private CheckinServiceImpl checkinService;

	@RequestMapping(value = "/view-product-order/{id}", method = RequestMethod.GET)
	public String vieworder(Model model, HttpSession session, @PathVariable("id") int id) {
		Order order = checkinService.findOrderbyId(id);
		if (order.getStatus() != null && order.getStatus()) {
			return "redirect:/admins/list-order";
		}
		OrderProduct orderProduct = checkinService.findOrderbyIdView(id);

		model.addAttribute("order", orderProduct);
		return "view-product-order";
	}

	@RequestMapping(value = "/view-product-order/{id}", method = RequestMethod.POST)
	public String vieworder(Model model, @PathVariable("id") int id) {
		Order order = checkinService.findOrderbyId(id);
		order.setStatus(true);
		checkinService.update(order);
		// goi mail cho khách hàng thong bao da chuyen hang
		StringBuilder message = new StringBuilder();
		message.append("<p style='font-size:36px;'><img src='cid:identifier1234' width='90' height='90'> Xin chào bạn "
				+ order.getUser().getFirstname() + " " + order.getUser().getFirstname() + ". </p><br>");
		message.append("<h2 style='color: #262626'>Đơn hàng đang được vận chuyển. </h2><br>");
		message.append("<hr>");
		message.append("Minimalism Shop xin chân thành cảm ơn");
		userService.sendMail(order.getUser().getEmail(), message.toString());

		model.addAttribute("notification", "ship");
		
		return "redirect:/admins/list-order";

	}

	@RequestMapping(value = "/print-order/{id}", method = RequestMethod.GET)
	public String printorder(Model model,HttpSession session, @PathVariable("id") int id) {
		OrderProduct orderProduct = checkinService.findOrderbyIdView(id);

		 JasperReportBuilder report = DynamicReports.report();//a new report
			report
			.addBackground(Components.text("\nName: "+ orderProduct.getName()+ "\nAddress: "+ orderProduct.getAddress() + "\nPhone: "+ orderProduct.getPhone()))
			.columns(	
			      Columns.column("Product", "name", DataTypes.stringType()),
			      Columns.column("Category", "category", DataTypes.stringType()),
			      Columns.column("Quantity", "quantity", DataTypes.stringType()),
			      Columns.column("Price", "price", DataTypes.stringType()))
			  .title(//title of the report
			      Components.text("ORDER REPORT " + id +"\n\n\n")
			     
				  .setHorizontalAlignment(HorizontalAlignment.CENTER))
				  .pageFooter(Components.pageXofY())//show page number on the page footer
				  .setDataSource(createDataSource(id));	


			try {
				report.addColumnFooter(Components.text("Subtotal: " + orderProduct.getSubtotal()));
		                //show the report
				report.show(false);

		                //export the report to a pdf file
				report.toPdf(new FileOutputStream("D:/report"+id +".pdf"));
			} catch (DRException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			model.addAttribute("order", orderProduct);
			return "redirect:/admins/view-product-order/"+id;
	}

	private JRDataSource createDataSource(int id) {
		OrderProduct orderProduct = checkinService.findOrderbyIdView(id);

		DRDataSource dataSource = new DRDataSource("name", "category", "quantity", "price");
		for (ProductDto product : orderProduct.getLstProduct()) {
			dataSource.add(product.getName(), product.getCategory(), String.valueOf(product.getQuantity()),
					String.valueOf(product.getPrice()));
		}

		return dataSource;
	}

}
