package com.costaoeste.learnenglish.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;


import com.costaoeste.learnenglish.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardDialog extends AppCompatDialog implements View.OnClickListener{

    static final int KEYCODE_LANGUAGE_SWITCH_ENG = -102;


    Builder mBuilder;
    Context mContext;

    @BindView(R.id.input_dialog_text)
    AppCompatEditText mInput;

    @BindView(R.id.text_dialog_ok)
    AppCompatTextView mTextOk;

    @BindView(R.id.text_dialog_cancel)
    AppCompatTextView mTextCancel;

    @BindView(R.id.layout_input_dialog_text)
    TextInputLayout mInputLayout;

    @BindView(R.id.image_dialog_header)
    ImageView mImageHeader;




    public CardDialog(Context context, Builder builder) {
        super(context, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth);
        setContentView(R.layout.card_dialog);
        ButterKnife.bind(this);
        this.mBuilder = builder;
        this.mContext = builder.context;
    }

    public interface OnClickOkListener {
        public void locationName(String locationName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void buildDialog() {

        mTextOk.setText(!TextUtils.isEmpty(mBuilder.positiveText) ? mBuilder.positiveText : mContext.getResources().getString(R.string.ok));
        mTextOk.setTextColor(mBuilder.positiveTextColor != 0 ? ContextCompat.getColor(mContext, mBuilder.positiveTextColor) : ContextCompat.getColor(mContext, R.color.colorPrimary));

        mTextCancel.setText(!TextUtils.isEmpty(mBuilder.negativeText) ? mBuilder.negativeText : mContext.getResources().getString(R.string.cancel));
        mTextCancel.setTextColor(mBuilder.negativeTextColor != 0 ? ContextCompat.getColor(mContext, mBuilder.negativeTextColor) : ContextCompat.getColor(mContext, R.color.colorAccent));

        mInput.setHint(!TextUtils.isEmpty(mBuilder.hintText) ? mBuilder.hintText : mContext.getResources().getString(R.string.hint_enter_vocabulary));

        mTextOk.setOnClickListener(this);
        mTextCancel.setOnClickListener(this);

        if (mBuilder.headerImageResource != 0) {
            mImageHeader.setImageResource(mBuilder.headerImageResource);
        } else {
            mImageHeader.setImageResource(android.R.drawable.alert_dark_frame);
        }
    }

    public void init() {

        buildDialog();


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.text_dialog_ok) {
            onClickOk();
        } else if (view.getId() == R.id.text_dialog_cancel) {
            dismiss();
        }
    }

    private void onClickOk() {
        if (mBuilder.okListener != null) {
            mBuilder.okListener.locationName(mInput.getText().toString().trim());
        }
        dismiss();
    }

    public static class Builder {
        private Context context;
        private String positiveText, negativeText, hintText;
        private @ColorRes int positiveTextColor, negativeTextColor, hintTextColor;
        private @DrawableRes int headerImageResource;

        private OnClickOkListener okListener;


        public Builder(Context context) {
            this.context = context;
        }

        public Builder setOkListener(OnClickOkListener listener) {
            this.okListener = listener;
            return this;
        }


        public Builder setPositiveText(String positiveText) {
            this.positiveText = positiveText;
            return this;
        }

        public Builder setNegativeText(String negativeText) {
            this.negativeText = negativeText;
            return this;
        }

        public Builder setHintText(String hintText) {
            this.hintText = hintText;
            return this;
        }

        public Builder setPositiveTextColor(@ColorRes int positiveTextColor) {
            this.positiveTextColor = positiveTextColor;
            return this;
        }

        public Builder setNegativeTextColor(@ColorRes int negativeTextColor) {
            this.negativeTextColor = negativeTextColor;
            return this;
        }

        public Builder setHintTextColor(@ColorRes int hintTextColor) {
            this.hintTextColor = hintTextColor;
            return this;
        }

        public Builder setHeaderImage(@DrawableRes int headerImageResource) {
            this.headerImageResource = headerImageResource;
            return this;
        }

        public CardDialog build() {
            return new CardDialog(context, this);
        }


    }

}