package com.afocus.pbuilder.oracle.model;

import java.util.List;

/**
 * USER_VIEWS Description of the user's own views
 * 
 * @author liuwu
 * @date 2015-09-11
 * @company afocus
 * @version 5.0
 */
@SuppressWarnings("serial")
public class UserViews extends UserTabOrViews{
	

    /** @column Name of the view */
	private String viewName;

    /** @column Length of the view text */
	private Integer textLength;

    /** @column View text */
	private String text;

    /** @column Length of the type clause of the object view */
	private Integer typeTextLength;

    /** @column Type clause of the object view */
	private String typeText;

    /** @column Length of the WITH OBJECT OID clause of the object view */
	private Integer oidTextLength;

    /** @column WITH OBJECT OID clause of the object view */
	private String oidText;

    /** @column Owner of the type of the view if the view is a object view */
	private String viewTypeOwner;

    /** @column Type of the view if the view is a object view */
	private String viewType;

    /** @column Name of the superview, if view is a subview */
	private String superviewName;
	
	/**
	 * 关联注释
	 */
	private String comments;
	
	private List<UserTabColumns> userTabColumnsList;

	public UserViews(){}


	/**
	 * 获取Name of the view
	 */
	public String getViewName() {
    	return viewName;
    }
  	
	/**
	 * 设置Name of the view
	 */
	public void setViewName(String viewName) {
    	this.viewName = viewName;
    }

	/**
	 * 获取Length of the view text
	 */
	public Integer getTextLength() {
    	return textLength;
    }
  	
	/**
	 * 设置Length of the view text
	 */
	public void setTextLength(Integer textLength) {
    	this.textLength = textLength;
    }

	/**
	 * 获取View text
	 */
	public String getText() {
    	return text;
    }
  	
	/**
	 * 设置View text
	 */
	public void setText(String text) {
    	this.text = text;
    }

	/**
	 * 获取Length of the type clause of the object view
	 */
	public Integer getTypeTextLength() {
    	return typeTextLength;
    }
  	
	/**
	 * 设置Length of the type clause of the object view
	 */
	public void setTypeTextLength(Integer typeTextLength) {
    	this.typeTextLength = typeTextLength;
    }

	/**
	 * 获取Type clause of the object view
	 */
	public String getTypeText() {
    	return typeText;
    }
  	
	/**
	 * 设置Type clause of the object view
	 */
	public void setTypeText(String typeText) {
    	this.typeText = typeText;
    }

	/**
	 * 获取Length of the WITH OBJECT OID clause of the object view
	 */
	public Integer getOidTextLength() {
    	return oidTextLength;
    }
  	
	/**
	 * 设置Length of the WITH OBJECT OID clause of the object view
	 */
	public void setOidTextLength(Integer oidTextLength) {
    	this.oidTextLength = oidTextLength;
    }

	/**
	 * 获取WITH OBJECT OID clause of the object view
	 */
	public String getOidText() {
    	return oidText;
    }
  	
	/**
	 * 设置WITH OBJECT OID clause of the object view
	 */
	public void setOidText(String oidText) {
    	this.oidText = oidText;
    }

	/**
	 * 获取Owner of the type of the view if the view is a object view
	 */
	public String getViewTypeOwner() {
    	return viewTypeOwner;
    }
  	
	/**
	 * 设置Owner of the type of the view if the view is a object view
	 */
	public void setViewTypeOwner(String viewTypeOwner) {
    	this.viewTypeOwner = viewTypeOwner;
    }

	/**
	 * 获取Type of the view if the view is a object view
	 */
	public String getViewType() {
    	return viewType;
    }
  	
	/**
	 * 设置Type of the view if the view is a object view
	 */
	public void setViewType(String viewType) {
    	this.viewType = viewType;
    }

	/**
	 * 获取Name of the superview, if view is a subview
	 */
	public String getSuperviewName() {
    	return superviewName;
    }
  	
	/**
	 * 设置Name of the superview, if view is a subview
	 */
	public void setSuperviewName(String superviewName) {
    	this.superviewName = superviewName;
    }

	@Override
    public String toString() {
		return new StringBuilder().append("UserViews{").
			append("viewName=").append(viewName).
			append(",textLength=").append(textLength).
			append(",text=").append(text).
			append(",typeTextLength=").append(typeTextLength).
			append(",typeText=").append(typeText).
			append(",oidTextLength=").append(oidTextLength).
			append(",oidText=").append(oidText).
			append(",viewTypeOwner=").append(viewTypeOwner).
			append(",viewType=").append(viewType).
			append(",superviewName=").append(superviewName).
			append('}').toString();
    }
    
    /**
	 * 比较字段：
	 * viewName, textLength, text, typeTextLength, typeText,
	 * oidTextLength, oidText, viewTypeOwner, viewType, superviewName
	 */
	public boolean equals(Object o){
		if(!(o instanceof UserViews)) return false;
		UserViews v = (UserViews)o;
		return (viewName==null && v.viewName==null || viewName != null && viewName.equals(v.viewName))
			&& (textLength==null && v.textLength==null || textLength != null && textLength.equals(v.textLength))
			&& (text==null && v.text==null || text != null && text.equals(v.text))
			&& (typeTextLength==null && v.typeTextLength==null || typeTextLength != null && typeTextLength.equals(v.typeTextLength))
			&& (typeText==null && v.typeText==null || typeText != null && typeText.equals(v.typeText))
			&& (oidTextLength==null && v.oidTextLength==null || oidTextLength != null && oidTextLength.equals(v.oidTextLength))
			&& (oidText==null && v.oidText==null || oidText != null && oidText.equals(v.oidText))
			&& (viewTypeOwner==null && v.viewTypeOwner==null || viewTypeOwner != null && viewTypeOwner.equals(v.viewTypeOwner))
			&& (viewType==null && v.viewType==null || viewType != null && viewType.equals(v.viewType))
			&& (superviewName==null && v.superviewName==null || superviewName != null && superviewName.equals(v.superviewName))
		;
	}
	
	/**
	 * 散列字段：
	 * viewName, textLength, text, typeTextLength, typeText,
	 * oidTextLength, oidText, viewTypeOwner, viewType, superviewName
	 */
	public int hashCode(){
		int h = 1;
		h = 31 * h + (viewName==null ? 0 : viewName.hashCode());
		h = 31 * h + (textLength==null ? 0 : textLength.hashCode());
		h = 31 * h + (text==null ? 0 : text.hashCode());
		h = 31 * h + (typeTextLength==null ? 0 : typeTextLength.hashCode());
		h = 31 * h + (typeText==null ? 0 : typeText.hashCode());
		h = 31 * h + (oidTextLength==null ? 0 : oidTextLength.hashCode());
		h = 31 * h + (oidText==null ? 0 : oidText.hashCode());
		h = 31 * h + (viewTypeOwner==null ? 0 : viewTypeOwner.hashCode());
		h = 31 * h + (viewType==null ? 0 : viewType.hashCode());
		h = 31 * h + (superviewName==null ? 0 : superviewName.hashCode());
		return h;
	}
	
	/**
	 * 复制对象,复制了以下字段
	 * viewName, textLength, text, typeTextLength, typeText,
	 * oidTextLength, oidText, viewTypeOwner, viewType, superviewName
	 */
	public UserViews copy(){
		UserViews m = new UserViews();
     	m.viewName = viewName;
     	m.textLength = textLength;
     	m.text = text;
     	m.typeTextLength = typeTextLength;
     	m.typeText = typeText;
     	m.oidTextLength = oidTextLength;
     	m.oidText = oidText;
     	m.viewTypeOwner = viewTypeOwner;
     	m.viewType = viewType;
     	m.superviewName = superviewName;
		return m;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<UserTabColumns> getUserTabColumnsList() {
		return userTabColumnsList;
	}

	public void setUserTabColumnsList(List<UserTabColumns> userTabColumnsList) {
		this.userTabColumnsList = userTabColumnsList;
	}
	
	@Override
	public String getTableName() {
		return viewName;
	}

	@Override
	public String getTablespaceName() {
		return null;
	}

	@Override
	public String getTableType() {
		return "VIEW";
	}
}
