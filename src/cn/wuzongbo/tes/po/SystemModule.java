package cn.wuzongbo.tes.po;

import java.io.Serializable;

public class SystemModule  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3478257958992881487L;

	private Short modId;

    private String module;

    private Byte level;

    private String controller;

    private String action;

    private String title;

    private Byte visible;

    private Short parentId;

    private Short orderby;

    private String icon;

    public Short getModId() {
        return modId;
    }

    public void setModId(Short modId) {
        this.modId = modId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller == null ? null : controller.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getVisible() {
        return visible;
    }

    public void setVisible(Byte visible) {
        this.visible = visible;
    }

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    public Short getOrderby() {
        return orderby;
    }

    public void setOrderby(Short orderby) {
        this.orderby = orderby;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}