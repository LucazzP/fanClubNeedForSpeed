package dev.polazzo.fanClubNeedForSpeed.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product {
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @lombok.Getter(onMethod_ = {@JsonProperty("site_id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("site_id")})
    private String siteId;
    @lombok.Getter(onMethod_ = {@JsonProperty("title")})
    @lombok.Setter(onMethod_ = {@JsonProperty("title")})
    private String title;
    @lombok.Getter(onMethod_ = {@JsonProperty("id_integracao")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id_integracao")})
    private Long idIntegracao;
    @lombok.Getter(onMethod_ = {@JsonProperty("subtitle")})
    @lombok.Setter(onMethod_ = {@JsonProperty("subtitle")})
    private Object subtitle;
    @lombok.Getter(onMethod_ = {@JsonProperty("seller_id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("seller_id")})
    private Long sellerId;
    @lombok.Getter(onMethod_ = {@JsonProperty("price")})
    @lombok.Setter(onMethod_ = {@JsonProperty("price")})
    private Long price;
    @lombok.Getter(onMethod_ = {@JsonProperty("base_price")})
    @lombok.Setter(onMethod_ = {@JsonProperty("base_price")})
    private Long basePrice;
    @lombok.Getter(onMethod_ = {@JsonProperty("original_price")})
    @lombok.Setter(onMethod_ = {@JsonProperty("original_price")})
    private Object originalPrice;
    @lombok.Getter(onMethod_ = {@JsonProperty("currency_id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("currency_id")})
    private String currencyId;
    @lombok.Getter(onMethod_ = {@JsonProperty("initial_quantity")})
    @lombok.Setter(onMethod_ = {@JsonProperty("initial_quantity")})
    private Long initialQuantity;
    @lombok.Getter(onMethod_ = {@JsonProperty("available_quantity")})
    @lombok.Setter(onMethod_ = {@JsonProperty("available_quantity")})
    private Long availableQuantity;
    @lombok.Getter(onMethod_ = {@JsonProperty("start_time")})
    @lombok.Setter(onMethod_ = {@JsonProperty("start_time")})
    private OffsetDateTime startTime;
    @lombok.Getter(onMethod_ = {@JsonProperty("stop_time")})
    @lombok.Setter(onMethod_ = {@JsonProperty("stop_time")})
    private OffsetDateTime stopTime;
    @lombok.Getter(onMethod_ = {@JsonProperty("condition")})
    @lombok.Setter(onMethod_ = {@JsonProperty("condition")})
    private String condition;
    @lombok.Getter(onMethod_ = {@JsonProperty("permalink")})
    @lombok.Setter(onMethod_ = {@JsonProperty("permalink")})
    private String permalink;
    @lombok.Getter(onMethod_ = {@JsonProperty("seller_address")})
    @lombok.Setter(onMethod_ = {@JsonProperty("seller_address")})
    private SellerAddress sellerAddress;
    @lombok.Getter(onMethod_ = {@JsonProperty("seller_contact")})
    @lombok.Setter(onMethod_ = {@JsonProperty("seller_contact")})
    private Object sellerContact;
    @lombok.Getter(onMethod_ = {@JsonProperty("attributes")})
    @lombok.Setter(onMethod_ = {@JsonProperty("attributes")})
    private Attribute[] attributes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(siteId, product.siteId) && Objects.equals(title, product.title) && Objects.equals(idIntegracao, product.idIntegracao) && Objects.equals(subtitle, product.subtitle) && Objects.equals(sellerId, product.sellerId) && Objects.equals(price, product.price) && Objects.equals(basePrice, product.basePrice) && Objects.equals(originalPrice, product.originalPrice) && Objects.equals(currencyId, product.currencyId) && Objects.equals(initialQuantity, product.initialQuantity) && Objects.equals(availableQuantity, product.availableQuantity) && Objects.equals(startTime, product.startTime) && Objects.equals(stopTime, product.stopTime) && Objects.equals(condition, product.condition) && Objects.equals(permalink, product.permalink) && Objects.equals(sellerAddress, product.sellerAddress) && Objects.equals(sellerContact, product.sellerContact) && Arrays.equals(attributes, product.attributes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, siteId, title, idIntegracao, subtitle, sellerId, price, basePrice, originalPrice, currencyId, initialQuantity, availableQuantity, startTime, stopTime, condition, permalink, sellerAddress, sellerContact);
        result = 31 * result + Arrays.hashCode(attributes);
        return result;
    }
}
