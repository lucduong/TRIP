/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 - 2014 LTV Co., Ltd  All rights reserved
 *
 * Created  : Feb 23, 2014
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Feb 23, 2014    	   jack        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.http;

public enum HttpMethod {
	/**
	 * GET is a read only operation. It is both an idempotent and safe
	 * operation. Idempotent means that no matter how many times you apply the
	 * operation, the result is always the same. The act of reading an HTML
	 * document shouldn't change the document. Safe means that invoking a GET
	 * does not change the state of the server at all. That, other than request
	 * load, the operation will not affect the server.
	 */
	GET,
	/**
	 * POST is the only non-idempotent and unsafe operation of HTTP. It is a
	 * method where the constraints are relaxed to give some flexibility to the
	 * user. In a RESTFul system, POST usually models a factory service. Where
	 * with PUT you know exactly which object you are creating, with POST you
	 * are relying on a factory service to create the object for you.
	 */
	POST,
	/**
	 * PUT is usually modeled as an insert or update. It is also idempotent.
	 * When using PUT, the client knows the identity of the resource it is
	 * creating or updating. It is idempotent because sending the same PUT
	 * message more than once has no affect on the underlying service. An
	 * analogy is an MS Word document that you are editing. No matter how many
	 * times you click the “save” button, the file that stores your document
	 * will logically be the same document.
	 */
	PUT,
	/**
	 * DELETE is used to remove services. It is idempotent as well.
	 */
	DELETE,
	/**
	 * 
	 */
	OPTIONS
}
