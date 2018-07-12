package com.example.xyzreader.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleBodyAdapter extends RecyclerView.Adapter<ArticleBodyAdapter.ViewHolder> {
    private Context mContext;
    private String[] articleBodyLines;

    private static final String LOG_TAG = ArticleBodyAdapter.class.getSimpleName();

    public ArticleBodyAdapter(Context context, String[] lines) {
        mContext = context;
        articleBodyLines = lines;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.article_body)
        TextView line;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }


    @Override
    public ArticleBodyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item_article_body, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String line = articleBodyLines[position];
        holder.line.setText(line);
    }

    @Override
    public int getItemCount() {
        if (articleBodyLines == null)
            return 0;
        return articleBodyLines.length;
    }

    public void setArticleBodyLines(String[] lines) {
        articleBodyLines = lines;
        notifyDataSetChanged();
    }
}