package me.fattycat.kun.bustimer.favourite;

import me.fattycat.kun.bustimer.ui.base.BasePresenter;
import me.fattycat.kun.bustimer.ui.base.BaseView;

/**
 * Author: Kelvinkun
 * Date: 16/6/30
 */

public interface FavouriteContract {
    interface View extends BaseView<Presenter> {

        void onDataLoaded();
    }

    interface Presenter extends BasePresenter {

        void loadLocalData();
    }
}
