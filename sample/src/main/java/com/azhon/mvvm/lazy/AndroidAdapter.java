package com.azhon.mvvm.lazy;

import com.azhon.basic.adapter.BaseDBRVAdapter;
import com.azhon.mvvm.R;
import com.azhon.mvvm.BR;
import com.azhon.mvvm.databinding.ItemJueJinBinding;

/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.mvvm.lazy
 * 文件名:    AndroidAdapter
 * 创建时间:  2019-03-29 on 10:44
 * 描述:     TODO
 *
 * @author 阿钟
 */

public class AndroidAdapter extends BaseDBRVAdapter<JueJinBean.DBean.EntrylistBean, ItemJueJinBinding> {

    public AndroidAdapter() {
        super(R.layout.item_jue_jin, BR.bean);
    }
}
