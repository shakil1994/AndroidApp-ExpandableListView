package in.imranalam.app.expandablematerialnavigationdrawer.navigation;


import android.content.Context;

import in.imranalam.app.expandablematerialnavigationdrawer.R;

import java.util.ArrayList;
import java.util.List;


public class CustomDataProvider {

    private static final int MAX_LEVELS = 3;

    private static final int LEVEL_1 = 1;
    private static final int LEVEL_2 = 2;
    private static final int LEVEL_3 = 3;
    private static List<BaseItem> mMenu = new ArrayList<>();
    Context context;

    public static List<BaseItem> getInitialItems() {
        //return getSubItems(new GroupItem("root"));

        List<BaseItem> rootMenu = new ArrayList<>();

        rootMenu.add(new Item("Home", R.drawable.ic_home_black_24dp));
        rootMenu.add(new GroupItem("Category", R.drawable.ic_widgets_black_24dp));
        rootMenu.add(new GroupItem("Assignments", R.drawable.ic_assignment_black_24dp));
        rootMenu.add(new GroupItem("Company", R.drawable.ic_assignment_black_24dp));
        rootMenu.add(new Item("Help", R.drawable.ic_help_black_24dp));
        rootMenu.add(new Item("About Us", R.drawable.ic_error_black_24dp));
        //rootMenu.add(new Item("About Company", R.drawable.ic_error_black_24dp));
        return rootMenu;
    }

    public static List<BaseItem> getSubItems(BaseItem baseItem) {

        List<BaseItem> result = new ArrayList<>();
        int level = ((GroupItem) baseItem).getLevel() + 1;
        String menuItem = baseItem.getName();

        GroupItem groupItem = (GroupItem) baseItem;
        if (groupItem.getLevel() >= MAX_LEVELS) {
            return null;
        }

        if (level == LEVEL_1) {
            switch (menuItem.toUpperCase()) {
                case "CATEGORY":
                    result = getListCategory();
                    break;
                case "ASSIGNMENTS":
                    result = getListAssignments();
                    break;
                case "COMPANY":
                    result = getListCompany();
                    break;
            }
        }
        return result;
    }

    public static boolean isExpandable(BaseItem baseItem) {
        return baseItem instanceof GroupItem;
    }

    private static List<BaseItem> getListCategory() {
        List<BaseItem> list = new ArrayList<>();
        list.add(new Item("Category-1"));
        list.add(new Item("Category-2"));
        list.add(new Item("Category-3"));
        return list;
    }

    private static List<BaseItem> getListAssignments() {
        List<BaseItem> list = new ArrayList<>();
        list.add(new Item("Assignment-1"));
        list.add(new Item("Assignment-2"));
        list.add(new Item("Assignment-3"));
        list.add(new Item("Assignment-4"));
        return list;
    }

    private static List<BaseItem> getListCompany() {
        List<BaseItem> list = new ArrayList<>();
        list.add(new Item("Company-1"));
        list.add(new Item("Company-2"));
        return list;
    }
}
