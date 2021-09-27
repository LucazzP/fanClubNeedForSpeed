package dev.polazzo.fanClubNeedForSpeed.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product {
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("id")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("site_id")
    private String siteId;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("title")
    @Column(unique = true, nullable = false)
    private String title;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("id_integracao")
    private Long idIntegracao;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("subtitle")
    private String subtitle;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("seller_id")
    private Long sellerId;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("price")
    @Column(nullable = false)
    private Integer price;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("base_price")
    private Integer basePrice;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("original_price")
    private Integer originalPrice;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("currency_id")
    private String currencyId;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("initial_quantity")
    @Column(nullable = false)
    private Long initialQuantity;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("available_quantity")
    @Column(nullable = false)
    private Long availableQuantity;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("start_time")
    private OffsetDateTime startTime;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("stop_time")
    private OffsetDateTime stopTime;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("condition")
    private String conditional;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("permalink")
    private String permalink;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("seller_address")
    @ManyToOne
    private SellerAddress sellerAddress;
    @lombok.Getter
    @lombok.Setter
    @JsonProperty("seller_contact")
    private String sellerContact;
    @Getter
    @Setter
    @JsonProperty("attributes")
    @ManyToMany
    @ToString.Exclude
    private List<Attribute> attributes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(siteId, product.siteId) && Objects.equals(title, product.title) && Objects.equals(idIntegracao, product.idIntegracao) && Objects.equals(subtitle, product.subtitle) && Objects.equals(sellerId, product.sellerId) && Objects.equals(price, product.price) && Objects.equals(basePrice, product.basePrice) && Objects.equals(originalPrice, product.originalPrice) && Objects.equals(currencyId, product.currencyId) && Objects.equals(initialQuantity, product.initialQuantity) && Objects.equals(availableQuantity, product.availableQuantity) && Objects.equals(startTime, product.startTime) && Objects.equals(stopTime, product.stopTime) && Objects.equals(conditional, product.conditional) && Objects.equals(permalink, product.permalink) && Objects.equals(sellerAddress, product.sellerAddress) && Objects.equals(sellerContact, product.sellerContact) && attributes.equals(product.attributes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, siteId, title, idIntegracao, subtitle, sellerId, price, basePrice, originalPrice, currencyId, initialQuantity, availableQuantity, startTime, stopTime, conditional, permalink, sellerAddress, sellerContact);
        result = 31 * result + attributes.hashCode();
        return result;
    }
}
