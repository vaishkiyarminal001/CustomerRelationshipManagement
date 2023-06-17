package com.masai.entity;

import java.util.List;

import jakarta.persistence.*;

//Customer class

@Entity
@Table(name = "Customer")
public class Customer {
 @Id
 @Column(name = "id")
 private String id;

 @Column(name = "name")
 private String name;

 @Column(name = "email")
 private String email;

 @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
 private List<Issue> issues;

 public Customer() {
 }

 public Customer(String id, String name, String email) {
     this.id = id;
     this.name = name;
     this.email = email;
 }

 // Getters and Setters

 public String getId() {
     return id;
 }

 public void setId(String id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public List<Issue> getIssues() {
     return issues;
 }

 public void setIssues(List<Issue> issues) {
     this.issues = issues;
 }
}
