/*=========================================================
 *@FileName : LTVResponse.java
 *@FileTitle : LTVResponse
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 
 * 1.0 Creation
=========================================================*/
package vn.com.ltv.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import android.view.View;

import com.google.gson.internal.LinkedTreeMap;

/**
 * Holder for both Model and View in the web MVC framework. Note that these are
 * entirely distinct. This class merely holds both to make it possible for a
 * controller to return both model and view in a single return value.
 * 
 * <p>
 * Represents a model and view returned by a handler, to be resolved by a
 * DispatcherServlet. The view can take the form of a String view name which
 * will need to be resolved by a ViewResolver object; alternatively a View
 * object can be specified directly. The model is a Map, allowing the use of
 * multiple objects keyed by name.
 * 
 * @since J2EE 1.6
 * @see DispatcherServlet
 * @see ViewResolver
 * @see HandlerAdapter#handle
 * @see org.springframework.web.servlet.mvc.Controller#handleRequest
 */
public class LTVResponse implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 4506449384301876755L;


	/** Model Map */
	private LTVModelMap modelMap;

	/**
	 * Default constructor for bean-style usage: populating bean properties
	 * instead of passing in constructor arguments.
	 * 
	 * @see #setView(View)
	 * @see #setViewName(String)
	 */
	public LTVResponse() {
	}

	public void setModelMap(LTVModelMap modelMap) {
		this.modelMap = modelMap;
	}

	public LTVModelMap getModelMap() {
		return modelMap;
	}

	/**
	 * Returns the value to which the specified key is mapped
	 * 
	 * @param attributeName
	 *            name of the object to add to the model
	 * @return the value to which the specified key is mapped, or null if this
	 *         map contains no mapping for the key
	 */
	public Object getObject(String attributeName) {
		return getModelMap().get(attributeName);
	}

	@SuppressWarnings("unchecked")
	public <T> Object getAttribute(String attributeName, Class<T> clz) {
		Object linkedHashMap = getModelMap().get(attributeName);
		ObjectMapper mapper = new ObjectMapper();
		if (linkedHashMap instanceof List<?>) {
			List<T> data = new ArrayList<T>();
			List<LinkedTreeMap<String, Object>> linkedHashMaps = (List<LinkedTreeMap<String, Object>>) linkedHashMap;
			for (LinkedTreeMap<String, Object> obj : linkedHashMaps) {
				T value = mapper.convertValue(obj, clz);
				data.add(value);
			}
			return data;
		} else {
			T data = mapper.convertValue(linkedHashMap, clz);
			return data;
		}
	}
}
