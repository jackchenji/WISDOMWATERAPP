package com.cdwm.app.ui.tab.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cdwm.app.R;
import com.cdwm.app.ui.tab.TabActivity;
import com.cdwm.app.ui.tab.fragment.adapter.RcvGridTitleAdapter;
import com.cdwm.app.ui.tab.fragment.model.GridItem;
import com.cdwm.app.util.MenuConstants;
import com.cdwm.app.util.SysTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private TabActivity parentContent ;
    private View currentContent;
    private OnFragmentInteractionListener mListener;

    //////////////////////////////////////////////////////
    private RecyclerView recyclerView;
    private List<GridItem> dataList;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //////////////////////////////
        parentContent  =  (TabActivity) getContext();
        this.currentContent = inflater.inflate(R.layout.fragment_home, container, false);



        /*

            数据示范
            [
                {
                    "title":"超比",
                    "menuList":[
                        {"menuId":"000001","menuName":"超比菜单1"},
                        {"menuId":"000002","menuName":"超比菜单2"}
                    ]

                }.
                {
                    "title":"鱼丸",
                    "menuList":[
                        {"menuId":"100001","menuName":"鱼丸菜单1"},
                        {"menuId":"100002","menuName":"鱼丸菜单2"},
                        {"menuId":"100003","menuName":"鱼丸菜单3"},
                        {"menuId":"100003","menuName":"鱼丸菜单4"},
                        {"menuId":"100003","menuName":"鱼丸菜单5"},
                        {"menuId":"100003","menuName":"鱼丸菜单6"},
                        {"menuId":"100003","menuName":"鱼丸菜单7"}

                    ]

                }.
                {
                    "title":"小咪咪",
                    "menuList":[
                        {"menuId":"100001","menuName":"小咪咪菜单1"},
                        {"menuId":"100002","menuName":"小咪咪菜单2"}
                    ]
                }
            ]



         */

        //////////////////////////////

        recyclerView = (RecyclerView)this.currentContent.findViewById(R.id.recycler_view);
        recyclerView.setBackground(getResources().getDrawable(R.drawable.white_ripple_bg));

        //设置一行几个项目
        GridLayoutManager gridLayoutManager = new GridLayoutManager(parentContent, 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        this.reloadAdapter(MenuConstants.getMenus());



        return this.currentContent;
    }

    /**
     * 设置adapter到RecyclerView控件内
     * @param list
     */
    public void reloadAdapter(List<Map<String,Object>> list){
        dataList = new ArrayList<>();

        //1.平铺所有数据到 allMenus
        List<Map<String, Object>> allMenus = new ArrayList<>();
        for (int t=0;t<list.size();t++){
            List<Map<String, Object>> __listPerObject = (List<Map<String, Object>> )list.get(t).get("menuList");
            if(__listPerObject != null && __listPerObject.size() > 0){
                for (int t2=0;t2<__listPerObject.size();t2++){
                    Map<String, Object> menuOneMap =  __listPerObject.get(t2);
                    allMenus.add(menuOneMap);
                }
            }
        }


        //2.将数据转换成GridItem数据
        for(int i = 0; i < allMenus.size(); i++){
            String menuName = SysTools.stringNullProcess(allMenus.get(i).get("menuName"));
            String menuId = SysTools.stringNullProcess(allMenus.get(i).get("menuId"));

            GridItem gridItem = new GridItem();
            gridItem.setText(menuName);
            gridItem.setRecordId(menuId);
            //图标设置
            if(allMenus.get(i).get("icon")!=null){
                gridItem.setDrawableId((int)allMenus.get(i).get("icon"));
            }else{
                gridItem.setDrawableId(R.drawable.icon_default);
            }
            dataList.add(gridItem);
        }

        RcvGridTitleAdapter adapter = new RcvGridTitleAdapter(parentContent, dataList);

        //3.加入SectionName数据
        int positionIdx = 0;
        for(int t=0;t<list.size();t++){
            if (t==0){
                //第一个必须是0
                adapter.addTitle(0, SysTools.stringNullProcess(list.get(0).get("title")));
            }else{
                //拿上一个元素的数据个数，计算Position
                List<Map<String, Object>> __listPerObject = (List<Map<String, Object>> )list.get(t-1).get("menuList");
                positionIdx +=  (__listPerObject.size() + 1);
                adapter.addTitle(positionIdx, SysTools.stringNullProcess(list.get(t).get("title")));
            }
        }

        //4.设置
        recyclerView.setAdapter(adapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
