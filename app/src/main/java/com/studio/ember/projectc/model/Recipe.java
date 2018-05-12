package com.studio.ember.projectc.model;

import java.util.List;

public class Recipe extends BaseModel{
    private int userId;
    private String name;
    private String description;
    private List<String> Photo;
    private List<RecipeIngredient> ingredients;
    private List<Step> steps;
    private Country country;
    private RecipeType recipeType;
    private int likes;
    private boolean favorite;

    public Recipe(int userId, String name, String description, List<String> photo, List<RecipeIngredient> ingredients, List<Step> steps, Country country, RecipeType recipeType, int likes, boolean favorite) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        Photo = photo;
        this.ingredients = ingredients;
        this.steps = steps;
        this.country = country;
        this.recipeType = recipeType;
        this.likes = likes;
        this.favorite = favorite;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public List<String> getPhoto() {
        return Photo;
    }

    public void setPhoto(List<String> photo) {
        Photo = photo;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public RecipeType getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(RecipeType recipeType) {
        this.recipeType = recipeType;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
