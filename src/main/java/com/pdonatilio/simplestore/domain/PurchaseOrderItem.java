package com.pdonatilio.simplestore.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PurchaseOrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private PurchaseOrderItemPK id = new PurchaseOrderItemPK();
    
    private Double discount;
    private Integer quantity;
    private Double price;
    
    public PurchaseOrderItem() {
    }

    public PurchaseOrderItem(PurchaseOrder purchaseOrder, Product product, Double discount, Integer quantity, Double price) {
        super();
        this.id.setPurchaseOrder(purchaseOrder);
        this.id.setProduct(product);
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
    }
    
    public PurchaseOrder getPurchaseOrder() {
        return id.getPurchaseOrder();
    }
    
    public Product getProduct() {
        return id.getProduct();
    }

    public PurchaseOrderItemPK getId() {
        return id;
    }

    public void setId(PurchaseOrderItemPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PurchaseOrderItem other = (PurchaseOrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}