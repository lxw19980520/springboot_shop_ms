package com.qa.springboot.pojo;

import java.util.Date;

public class ProductItem {
    private Long id;

    private String title;

    private Long price;

    private Integer num;

    private String image;

    private Integer news;

    private Integer recommend;

    private Long cid;
    private ProductCategory productCategory;
    

    public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	private Byte status;

    private Date created;

    private Date updated;
    
    
    private ProductItemDesc productItemDesc;
    
    public ProductItemDesc getProductItemDesc() {
		return productItemDesc;
	}

	public void setProductItemDesc(ProductItemDesc productItemDesc) {
		this.productItemDesc = productItemDesc;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    private boolean flag;
    public void setFlag(boolean flag) {
		this.flag = flag;
	}
    public String getImage() {
    	if(flag){
    		return image;
    	}
    	return "http://localhost:8083/img/"+image;
    }
    
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getNews() {
        return news;
    }

    public void setNews(Integer news) {
        this.news = news;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

	@Override
	public String toString() {
		return "ProductItem [id=" + id + ", title=" + title + ", price=" + price + ", num=" + num + ", image=" + image
				+ ", news=" + news + ", recommend=" + recommend + ", cid=" + cid + ", productCategory="
				+ productCategory + ", status=" + status + ", created=" + created + ", updated=" + updated
				+ ", productItemDesc=" + productItemDesc + "]";
	}
    
    
    
}