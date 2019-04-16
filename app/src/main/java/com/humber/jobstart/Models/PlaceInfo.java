package com.humber.jobstart.Models;

import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

/**
 * The type Place info.
 * A Model class for PlaceInfo for Maps activity
 */
public class PlaceInfo {

    private String name;
    private String address;
    private String phoneNumber;
    private String id;
    private Uri websiteUri;
    private LatLng latLng;
    private float rating;
    private String attributions;


    /**
     * Instantiates a new Place info.
     */
    public PlaceInfo() {
    }

    /**
     * Instantiates a new Place info.
     *
     * @param name         the name
     * @param address      the address
     * @param phoneNumber  the phone number
     * @param id           the id
     * @param websiteUri   the website uri
     * @param latLng       the lat lng
     * @param rating       the rating
     * @param attributions the attributions
     */
    public PlaceInfo(String name, String address, String phoneNumber, String id, Uri websiteUri, LatLng latLng, float rating, String attributions) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.websiteUri = websiteUri;
        this.latLng = latLng;
        this.rating = rating;
        this.attributions = attributions;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets website uri.
     *
     * @return the website uri
     */
    public Uri getWebsiteUri() {
        return websiteUri;
    }

    /**
     * Sets website uri.
     *
     * @param websiteUri the website uri
     */
    public void setWebsiteUri(Uri websiteUri) {
        this.websiteUri = websiteUri;
    }

    /**
     * Gets lat lng.
     *
     * @return the lat lng
     */
    public LatLng getLatLng() {
        return latLng;
    }

    /**
     * Sets lat lng.
     *
     * @param latLng the lat lng
     */
    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * Gets attributions.
     *
     * @return the attributions
     */
    public String getAttributions() {
        return attributions;
    }

    /**
     * Sets attributions.
     *
     * @param attributions the attributions
     */
    public void setAttributions(String attributions) {
        this.attributions = attributions;
    }

    @Override
    public String toString() {
        return "PlaceInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id='" + id + '\'' +
                ", websiteUri=" + websiteUri +
                ", latLng=" + latLng +
                ", rating=" + rating +
                ", attributions='" + attributions + '\'' +
                '}';
    }
}
