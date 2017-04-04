package action;

import java.util.List;

import org.apache.log4j.Logger;

import bean.dao.GoodsDAO;
import bean.vo.GoodsVo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport{
	
	private final static Logger log = Logger.getLogger(GoodsAction.class);
	
    private int pageNo = 1;
    private int pageCount;
    private List<GoodsVo> goodsList;
    
    public String findAllGoods() throws Exception{
//    	ActionContext ctx = ActionContext.getContext();
//        ctx.put("pageNo", pageNo);
    	GoodsDAO goodsDAO = new GoodsDAO();
		goodsList = goodsDAO.getGoodsByPage(pageNo);
		pageCount = goodsDAO.getPageCount();
    	return SUCCESS;
    }
    
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<GoodsVo> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsVo> goodsList) {
		this.goodsList = goodsList;
	}
}
