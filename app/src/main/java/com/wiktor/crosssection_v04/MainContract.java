package com.wiktor.crosssection_v04;

public interface MainContract {
    interface view {
        void showText();
    }
    interface Presenter{
        void onButtonWasClicked();
        void onDestroy();
    }
    interface Repository{
        String loadMessage();
    }
}
