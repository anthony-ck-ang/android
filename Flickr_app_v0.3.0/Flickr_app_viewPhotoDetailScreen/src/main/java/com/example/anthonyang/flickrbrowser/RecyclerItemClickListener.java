package com.example.anthonyang.flickrbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by anthonyang on 14/10/17.
 */
//these code will be implemented in the recycleViewAdapter -> check for quick or long user tap

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    public static interface OnItemClickListener
    {
        public void onItemClick(View view, int position);
        public void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mListener;
    private GestureDetector mGestureDetector;

    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            //* Motion events -> Object used to report movement (mouse, pen, finger, trackball) events.
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            /*
                 *Find the topmost view under the given point.
                 * @param x Horizontal position in pixels to search
                 * @param y Vertical position in pixels to search
             */
            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if(childView != null && mListener != null) {
                    mListener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
            }
        });
    }

    public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        /*
             * Analyzes the given motion event and if applicable triggers the
             * appropriate callbacks on the {@link OnGestureListener} supplied.
         */
        if(childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView,view.getChildAdapterPosition(childView));
        }
        return false;
    }

    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }


}