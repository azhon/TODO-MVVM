package com.azhon.mvvm.linkage;

import androidx.lifecycle.MutableLiveData;

import com.azhon.basic.lifecycle.BaseViewModel;

/**
 * createDate: 2019/03/27 on 14:155
 * desc:
 *
 * @author azhon
 */
public class LinkageViewModel extends BaseViewModel {

    private final MutableLiveData<Integer> progress = new MutableLiveData<>();

    public MutableLiveData<Integer> getProgress() {
        return progress;
    }
}
