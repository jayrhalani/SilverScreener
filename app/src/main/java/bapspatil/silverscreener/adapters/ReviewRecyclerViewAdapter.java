package bapspatil.silverscreener.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bapspatil.silverscreener.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewRecyclerViewAdapter extends RecyclerView.Adapter<ReviewRecyclerViewAdapter.ReviewItemViewHolder> {

    private ArrayList<String> mReviewAuthors, mReviewContents;
    private Context mContext;

    public ReviewRecyclerViewAdapter(Context context, ArrayList<String> reviewAuthors, ArrayList<String> reviewContents) {
        this.mContext = context;
        this.mReviewAuthors = reviewAuthors;
        this.mReviewContents = reviewContents;
    }

    @Override
    public ReviewItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_review_item, parent, false);
        return new ReviewItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewItemViewHolder holder, int position) {
        String reviewAuthor = mReviewAuthors.get(position);
        holder.reviewAuthorTextView.setText(reviewAuthor);
        holder.reviewContentTextView.setText(mReviewContents.get(position));
    }

    @Override
    public int getItemCount() {
        if (mReviewAuthors == null) return 0;
        else return mReviewAuthors.size();
    }

    public class ReviewItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.review_author_tv) TextView reviewAuthorTextView;
        @BindView(R.id.review_content_tv) TextView reviewContentTextView;

        ReviewItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}