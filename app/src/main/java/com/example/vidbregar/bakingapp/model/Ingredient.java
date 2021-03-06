package com.example.vidbregar.bakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ingredient implements Parcelable {
    @SerializedName("ingredient")
    private String ingredientName;
    @SerializedName("quantity")
    private double quantity;
    @SerializedName("measure")
    private String measure;
    @Expose(serialize = false, deserialize = false)
    private boolean isCheckedFromList;

    public Ingredient(String ingredientName, double quantity, String measure) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.measure = measure;
    }

    public Ingredient(Parcel in) {
        ingredientName = in.readString();
        quantity = in.readDouble();
        measure = in.readString();
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    public boolean isCheckedFromList() {
        return isCheckedFromList;
    }

    public void setCheckedFromList(boolean checkedFromList) {
        isCheckedFromList = checkedFromList;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ingredientName);
        dest.writeDouble(quantity);
        dest.writeString(measure);
    }
}
