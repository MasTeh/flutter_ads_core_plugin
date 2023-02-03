package me.taplika.flutter_ads_core_plugin.adfactory;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;

import me.taplika.flutter_ads_core_plugin.R;

public class CustomOptions {
    @Nullable
    Integer headlineTextColor;
    @Nullable
    Integer bodyTextColor;
    @Nullable
    Integer ctaTextColor;
    @Nullable
    Integer ctaBackgroundColor;
    @Nullable
    Integer secondaryTextColor; // for advertiser, store and price

    public static CustomOptions fromHashMap(@Nullable Map<String, Object> map) {
        CustomOptions result = new CustomOptions();
        if (map == null)
            return result;

        result.headlineTextColor = parseColor(map.get("headlineTextColor"));
        result.bodyTextColor = parseColor(map.get("bodyTextColor"));
        result.ctaTextColor = parseColor(map.get("ctaTextColor"));
        result.ctaBackgroundColor = parseColor(map.get("ctaBackgroundColor"));
        result.secondaryTextColor = parseColor(map.get("secondaryTextColor"));

        return result;
    }

    protected static void applyTextColor(@NonNull View root, @IdRes int textViewId, int color) {
        TextView textView = root.findViewById(textViewId);
        if (textView != null)
            textView.setTextColor(color);
    }

    protected static void applyBackgroundColor(@NonNull View root, @IdRes int viewId, int color) {
        View view = root.findViewById(viewId);
        if (view != null)
            view.setBackgroundColor(color);
    }

    public void applyToView(@NonNull View root) {
        applyHeadlineStyles(root);
        applyBodyStyles(root);
        applyCtaStyles(root);
        applySecondaryTextStyles(root);
    }


    private void applyHeadlineStyles(@NonNull View root) {
        if (headlineTextColor != null)
            applyTextColor(root, R.id.headline, headlineTextColor);
    }

    private void applyBodyStyles(@NonNull View root) {
        if (bodyTextColor != null)
            applyTextColor(root, R.id.body, bodyTextColor);
    }

    private void applyCtaStyles(@NonNull View root) {
        if (ctaTextColor != null)
            applyTextColor(root, R.id.cta_button, ctaTextColor);
        if (ctaBackgroundColor != null)
            applyBackgroundColor(root, R.id.cta_button, ctaBackgroundColor);
    }

    private void applySecondaryTextStyles(@NonNull View root) {
        if (secondaryTextColor == null)
            return;

        applyTextColor(root, R.id.ad_price, secondaryTextColor);
        applyTextColor(root, R.id.advertiser, secondaryTextColor);
        applyTextColor(root, R.id.store, secondaryTextColor);
    }

    protected static @Nullable Integer parseColor(@Nullable Object colorString) {
        if (colorString == null)
            return null;

        try {
            return Color.parseColor(String.valueOf(colorString));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}