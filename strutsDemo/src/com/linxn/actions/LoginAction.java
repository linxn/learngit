package com.linxn.actions;

import com.linxn.forms.LoginActionForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Created by linxn on 2017/4/19.
 */
public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        LoginActionForm loginActionForm = (com.linxn.forms.LoginActionForm) form;
        if(loginActionForm.getUserpwd().equals("123")){
            //把名字存放到request域
            request.setAttribute("username",loginActionForm.getUsername());
            return mapping.findForward("ok");
        }else{
            return mapping.findForward("err");
        }

        //return super.execute(mapping, form, request, response);
    }
}