package vn.com.ltv.model;

/**
 * Navigation Item
 * 
 * @author jack
 * 
 */
public class NavigationItem {
	private String title;
	private int icon;
	private int count;

	public NavigationItem() {

	}

	public NavigationItem(String title, int icon) {
		this.title = title;
		this.icon = icon;
	}

	public NavigationItem(String title, int icon, int count) {
		this.title = title;
		this.icon = icon;
		this.count = count;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
