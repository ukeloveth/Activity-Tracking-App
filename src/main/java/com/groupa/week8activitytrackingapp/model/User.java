package com.groupa.week8activitytrackingapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Email
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    @Size(min = 8, max = 16)
    private String password;
    @OneToMany
    private List<Task> tasks = new ArrayList<>();
}
