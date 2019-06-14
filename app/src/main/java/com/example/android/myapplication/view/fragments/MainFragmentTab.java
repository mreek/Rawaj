package com.example.android.myapplication.view.fragments;

import android.support.v4.app.Fragment;

public class MainFragmentTab extends Fragment {
    public static MainFragmentTab newInstance() {
        MainFragmentTab fragment = new MainFragmentTab();
        return fragment;
    }
//    private TabAdapter adapter;
  //  private TabLayout tableLayout;
   // private ViewPager viewPager;

//    @Nullable
 //   @Override
   /* public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabs, container, false);

        viewPager = view.findViewById(R.id.request_orders_view_pager);
        tableLayout = view.findViewById(R.id.request_orders_tabs);

        adapter = new TabAdapter(getFragmentManager());
        adapter.addFragment(new UserRecycler1(), "Tab 1");
        adapter.addFragment(new UserRecycler1(), "Tab 2");
        adapter.addFragment(new UserRecycler1(), "Tab 3");

        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);

        return view;
    }
    */
}
