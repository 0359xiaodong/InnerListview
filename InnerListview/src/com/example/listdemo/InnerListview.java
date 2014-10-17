/*
 * Copyright (c) 2014, �ൺ˾ͨ�Ƽ����޹�˾ All rights reserved.
 * File Name��InnerListview.java
 * Version��V1.0
 * Author��zhaokaiqiang
 * Date��2014-8-15
 */
package com.example.listdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * 
 * @ClassName: com.example.listdemo.InnerListview
 * @Description: ���Է���Listview�е�Listview
 * @author zhaokaiqiang
 * @date 2014-8-15 ����2:43:34
 * 
 */
public class InnerListview extends ListView {
	public InnerListview(Context context) {
		super(context);
	}

	public InnerListview(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public InnerListview(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		// ����ָ����listviewʱ���ø��ؼ�����ontouchȨ��,���ܹ���
		case MotionEvent.ACTION_DOWN:
			setParentScrollAble(false);
		case MotionEvent.ACTION_MOVE:
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			// ����ָ�ɿ�ʱ���ø��ؼ����»�ȡonTouchȨ��
			setParentScrollAble(true);
			break;

		}
		return super.onInterceptTouchEvent(ev);

	}

	// ���ø��ؼ��Ƿ���Ի�ȡ����������Ȩ��
	private void setParentScrollAble(boolean flag) {
		getParent().requestDisallowInterceptTouchEvent(!flag);
	}

}
