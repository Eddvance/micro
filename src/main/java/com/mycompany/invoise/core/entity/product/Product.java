package com.mycompany.invoise.core.entity.product;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="PRODUCT")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50)
    private String name;
    @ManyToMany
    @JoinTable(
            name="PRODUCT_CATEGORIES",
            joinColumns = {@JoinColumn(name="ID_PRODUCT")},
            inverseJoinColumns = {@JoinColumn(name="ID_CATEGORY")}
    )
    private List<Category> categories=new ArrayList<>();

    public Product(String name) {
        this.name = name;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
    }
}
/*echo "# MicroCoreInvoise" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Eddvance/MicroCoreInvoise.git
git push -u origin main*/