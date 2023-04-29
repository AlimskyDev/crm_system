package kz.bitlab.crm_system.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OrdersModels")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    @Column(name = "id") //необязательно
    private Long id;

    @Column(name ="name") //необязательно
    private String userName;

    @Column(name = "courseName") //необязательно
    private String courseName;

    @Column(name = "commentary", columnDefinition = "text") //необязательно
    private String commentary;

    @Column(name = "phone") //необязательно
    private String phone;

    @Column(name = "handled") //необязательно
    private boolean handled;
}
