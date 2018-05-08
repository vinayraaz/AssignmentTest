package vinay.assignmenttest.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vinay on 12/21/2017.
 */
@JsonObject
public class AppModel {
    @JsonField(name = "msg")
    private String msg;
    @JsonField(name = "restaurant_sliders")
    private List<RestaurantSlider> restaurantSliders = null;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RestaurantSlider> getRestaurantSliders() {
        return restaurantSliders;
    }

    public void setRestaurantSliders(List<RestaurantSlider> restaurantSliders) {
        this.restaurantSliders = restaurantSliders;
    }



}
