package com.bookshop.features.order.data.entity;


import com.bookshop.features.payment.data.entity.PaymentEntity;
import com.bookshop.features.user.data.entity.UserEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "PROCUREMENT")
public class OrderEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private LocalDateTime orderDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private List<OrderPositionEntity> orderPositions = new LinkedList<>();

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private DeliveryEntity deliveryEntity;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private BigDecimal fullPrice;

}
