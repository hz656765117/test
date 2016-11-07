package com.hz.business.api;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hz.base.Constants;
import com.hz.base.utils.DateUtil;
import com.hz.base.utils.IoUtil;
import com.hz.business.base.model.BaseModel;
import com.hz.business.controller.BaseController;
import com.hz.business.service.ResourceService;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * 图片上传api
 * @author HZBOX
 * @since 2016-09-28
 */
@Controller
@RequestMapping("/upload")
public class UploadPicAPI extends BaseController {
	@Resource ResourceService resourceService;
	
		@RequestMapping("/uploadPic")  
		public void uploadPic(HttpServletRequest request ,HttpServletResponse response,@ModelAttribute("baseModel") BaseModel baseModel,Model model) throws IOException{
			 
			
			JSONObject obj = new JSONObject();
			response.setContentType("text/json;charset=UTF-8");  
			response.setCharacterEncoding("UTF-8");
		
			System.out.println(baseModel.getPicStr());
			
			if(StringUtils.isBlank(baseModel.getUserId())){
				obj.put("success", false);
				obj.put("msg", "用户ID不能为空");
				obj.put("status", "4");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
		 
			if(StringUtils.isBlank(baseModel.getGroupId())){
				obj.put("success", false);
				obj.put("msg", "小组ID不能为空");
				obj.put("status", "5");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			if(StringUtils.isBlank(baseModel.getPicStr())){
				obj.put("success", false);
				obj.put("msg", "图片流不能为空");
				obj.put("status", "6");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			} 
			if(StringUtils.isBlank(baseModel.getPicName())){
				obj.put("success", false);
				obj.put("msg", "图片名不能为空");
				obj.put("status", "7");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}  
			String proPath = request.getSession().getServletContext().getRealPath(File.separator);
			String fileName = "upload"+File.separator + "pic" + File.separator + DateUtil.convertDateToString("yyyyMM",new Date());
			String filePath = proPath + File.separator + fileName;
			
			boolean success = IoUtil.makeDirectory(filePath);
			
			if(success){
				String suffix =baseModel.getPicName().substring(baseModel.getPicName().lastIndexOf(".")+1); 
				String picName = new Date().getTime()+"."+suffix;
				String path = filePath + File.separator +  picName;
				byte[] buf = Base64.decode(baseModel.getPicStr());
				System.out.println("byet[] length ===================="+buf.length);
				
				if(buf == null || buf.length<=0){
					obj.put("success", false);
					obj.put("msg", "图片上传失败");
					obj.put("status", "2");
					response.getWriter().write(new Gson().toJson(obj));
					return;
				}
				boolean status= IoUtil.writeFileByBytes(path, buf);
				if(status){
					String url = request.getRequestURL().toString();
					String p1 = url.substring(0,  url.lastIndexOf("/"));
					//String p2 = p1.substring(0, p1.lastIndexOf("/"));
					String picUrl = p1 + "/pic/"+ DateUtil.convertDateToString("yyyyMM",new Date()) +"/" +picName;
					com.hz.business.base.pojo.Resource res = new com.hz.business.base.pojo.Resource();
					res.setGroupId(baseModel.getGroupId());
					res.setName(picName);
					res.setUrl(picUrl);
					res.setUploadPersonId(baseModel.getUserId());
					res.setType(Constants.RESOURCE_TYPE_PIC);
					boolean result = resourceService.addResource(res);
					if(result ){
						obj.put("success", true);
						obj.put("msg", "图片上传成功");
						obj.put("status", "1");
						obj.put("picUrl", picUrl);
						response.getWriter().write(new Gson().toJson(obj));
						return;
					}else{
						obj.put("success", false);
						obj.put("msg", "图片上传失败");
						obj.put("status", "2");
						response.getWriter().write(new Gson().toJson(obj));
						return;
					}
				}else{
					obj.put("success", false);
					obj.put("msg", "图片上传失败");
					obj.put("status", "2");
					response.getWriter().write(new Gson().toJson(obj));
					return;
				}
			}else{
				obj.put("success", false);
				obj.put("msg", "图片存放文件夹创建失败");
				obj.put("status", "3");
				response.getWriter().write(new Gson().toJson(obj));
				return;
			}
			
			

			
			
			
			 
		}
		
		
	
}
