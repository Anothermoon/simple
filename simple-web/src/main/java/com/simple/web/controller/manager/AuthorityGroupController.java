package com.simple.web.controller.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.core.entity.AuthorityGroup;
import com.simple.core.model.LoginInfoModel;
import com.simple.core.service.AuthorityGroupService;
import com.simple.web.controller.AbstractController;

@Controller
@Scope("prototype")
@RequestMapping("/manager/authorityGroup/")
public class AuthorityGroupController extends AbstractController {

	@Autowired
	private AuthorityGroupService authorityGroupService;

	@ResponseBody
	@RequestMapping(value = "get/{id}", method = { RequestMethod.GET })
	public Object get(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) {
		try {
			return success(authorityGroupService.getByPk(id));
		} catch (Throwable e) {
			return fail(e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "getlist", method = { RequestMethod.POST })
	public Object getList(@RequestBody(required = false) Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		params = null == params ? new HashMap<String, Object>() : params;
		try {
			return success(authorityGroupService.getpage(checkPageAndSize(params)));
		} catch (Throwable e) {
			return fail(e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "put", method = { RequestMethod.PUT })
	public Object put(@RequestBody(required = false) Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		params = null == params ? new HashMap<String, Object>() : params;
		try {
			LoginInfoModel loginInfoModel = getLoginInfo(request);
			params.put("tenantId", loginInfoModel.getUser().getTenantId());
			authorityGroupService.saveOrUpdate(fillObject(new AuthorityGroup(), params));
			return success();
		} catch (Throwable e) {
			return fail(e);
		}
	}

	@ResponseBody
	@RequestMapping(value = "delete", method = { RequestMethod.DELETE })
	public Object delete(@RequestBody(required = false) Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		params = null == params ? new HashMap<String, Object>() : params;
		try {
			authorityGroupService.delete(params);
			return success();
		} catch (Throwable e) {
			return fail(e);
		}
	}

}
