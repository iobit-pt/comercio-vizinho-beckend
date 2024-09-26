package com.iobit.comercio_vizinho_be.entities;

import com.iobit.comercio_vizinho_be.entities.enums.GoodsType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_goods")
public class Goods implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String description;
    private Double price;

    @ManyToOne
    private User user;

    private Integer goodsType;

    public Goods() {
    }

    public Goods(Long id, String name, String description, Double price, GoodsType goodsType, User seller) {
        Id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.user = seller;
        setGoodsType(goodsType);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GoodsType getGoodsType() {
        return GoodsType.valueOf(goodsType);
    }

    public void setGoodsType(GoodsType goodsType) {
        if (goodsType != null) {
            this.goodsType = goodsType.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(Id, goods.Id) && Objects.equals(name, goods.name) && Objects.equals(description, goods.description) && Objects.equals(price, goods.price) && Objects.equals(user, goods.user) && Objects.equals(goodsType, goods.goodsType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, description, price, user, goodsType);
    }
}
