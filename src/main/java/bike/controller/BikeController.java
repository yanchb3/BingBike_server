package bike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import bike.object.Bike;
import bike.service.BikeService;



@RestController
public class BikeController{
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(String msg) {
		return "hello:"+msg;
	}
	
	@Autowired
	private BikeService bikeService;	
	
	@RequestMapping("/bike/add")
	@ResponseBody
	public String addBike(@RequestBody Bike bike) {
		//System.out.println(bike);
		bikeService.saveBike(bike);
		return "success";
	}
	
}
