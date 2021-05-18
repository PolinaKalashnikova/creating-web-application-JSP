package com.company.stags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.company.classes.Ad;
import com.company.classes.AdList;
import com.company.classes.AdListHelper;
import com.company.classes.User;
public class DeleteAd extends SimpleTagSupport {

	private Ad ad;

	public void setAd(Ad ad) {
		this.ad = ad;
	}
	public void doTag() throws JspException, IOException {

		String errorMessage = null;

		AdList adList = (AdList) getJspContext().getAttribute("ads", 
				PageContext.APPLICATION_SCOPE);

		User currentUser = (User) getJspContext().getAttribute("authUser", 
				PageContext.SESSION_SCOPE);

		if (currentUser==null || (ad.getId()>0 && 
				ad.getAuthorId()!=currentUser.getId())) {

			errorMessage = "Вы пытаетесь изменить сообщение, к которому не обладаете правами доступа!";
		}
		if (errorMessage==null) {

			adList.deleteAd(ad);

			AdListHelper.saveAdList(adList);
		}

		getJspContext().setAttribute("errorMessage", errorMessage, 
				PageContext.SESSION_SCOPE);
	}
}
