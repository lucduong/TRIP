/*
 *******************************************************************
 *
 * COPYRIGHT (C) 2013 - 2014 LTV Co., Ltd
 *
 * Created  : Jan 19, 2014
 * Change History
 * =================================================================
 * DATE                DEVELOPER        REVISION      DESCRIPTION
 * =================================================================
 * Jan 19, 2014    	   jack        1.0           First Created.
 * =================================================================
 *
 *
 *******************************************************************/
package vn.com.ltv.dto;

public class TripVO {
	private long trpId;
	private String trpNm;
	private String trpThumb;
	private long likeCnt;
	private long cmtCnt;
	private int memCnt;
	private String trpStrtDt;

	private Integer likeNo;
	private Integer disLikeNo;
	private Double ttlCost;
	private String stDt;
	private String endDt;
	private Integer minJoinNo;
	private Integer maxJoinNo;

	public TripVO() {
	};

	public TripVO(long trpId, String trpNm, String trpThumb, long likeCnt,
			long cmtCnt, int memCnt, String trpStrtDt) {
		super();
		this.trpId = trpId;
		this.trpNm = trpNm;
		this.trpThumb = trpThumb;
		this.likeCnt = likeCnt;
		this.cmtCnt = cmtCnt;
		this.memCnt = memCnt;
		this.trpStrtDt = trpStrtDt;
	}

	public long getTrpId() {
		return trpId;
	}

	public void setTrpId(long trpId) {
		this.trpId = trpId;
	}

	public String getTrpNm() {
		return trpNm;
	}

	public void setTrpNm(String trpNm) {
		this.trpNm = trpNm;
	}

	public long getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(long likeCnt) {
		this.likeCnt = likeCnt;
	}

	public long getCmtCnt() {
		return cmtCnt;
	}

	public void setCmtCnt(long cmtCnt) {
		this.cmtCnt = cmtCnt;
	}

	public int getMemCnt() {
		return memCnt;
	}

	public void setMemCnt(int memCnt) {
		this.memCnt = memCnt;
	}

	public String getTrpThumb() {
		return trpThumb;
	}

	public void setTrpThumb(String trpThumb) {
		this.trpThumb = trpThumb;
	}

	public String getTrpStrtDt() {
		return trpStrtDt;
	}

	public void setTrpStrtDt(String trpStrtDt) {
		this.trpStrtDt = trpStrtDt;
	}

	public Integer getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(Integer likeNo) {
		this.likeNo = likeNo;
	}

	public Integer getDisLikeNo() {
		return disLikeNo;
	}

	public void setDisLikeNo(Integer disLikeNo) {
		this.disLikeNo = disLikeNo;
	}

	public Double getTtlCost() {
		return ttlCost;
	}

	public void setTtlCost(Double ttlCost) {
		this.ttlCost = ttlCost;
	}

	public String getStDt() {
		return stDt;
	}

	public void setStDt(String stDt) {
		this.stDt = stDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public Integer getMinJoinNo() {
		return minJoinNo;
	}

	public void setMinJoinNo(Integer minJoinNo) {
		this.minJoinNo = minJoinNo;
	}

	public Integer getMaxJoinNo() {
		return maxJoinNo;
	}

	public void setMaxJoinNo(Integer maxJoinNo) {
		this.maxJoinNo = maxJoinNo;
	}

}
