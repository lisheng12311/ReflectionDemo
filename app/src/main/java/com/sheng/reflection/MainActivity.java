package com.sheng.reflection;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.bt_get_class, R.id.bt_get_constructor, R.id.bt_get_instance
            , R.id.bt_get_method, R.id.bt_get_field})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_get_class:
                showClass();
                break;
            case R.id.bt_get_constructor:
                showConstrucror();
                break;
            case R.id.bt_get_instance:
                showInstance();
                break;
            case R.id.bt_get_method:
                showMethod();
                break;
            case R.id.bt_get_field:
                showField();
                break;
        }
    }

    private void showField() {
        Class c1 = ReflectTest.class;
        try {
            //getField(String name)    根据变量名，返回一个具体的具有public属性的成员变量
            Field field1 = c1.getField("mPublicStr");
            Log.e("sheng", "sheng==" + field1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //getFields()    返回具有public属性的成员变量的数组
        Field[] fields1 = c1.getFields();
        for (int i = 0; i < fields1.length; i++) {
            Log.e("sheng", "Fillds1==" + i + "=" + fields1[i]);
        }

        try {
            Field field2 = c1.getDeclaredField("mProtectedStr");
            Log.e("sheng", "field2==" + field2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Field[] fields2 = c1.getDeclaredFields();
        for (int i = 0; i < fields2.length; i++) {
            Log.e("sheng", "fields2==" + i + "=" + fields2[i]);
        }

    }

    private void showMethod() {
        Class c1 = ReflectTest.class;
        try {
            //根据方法名和参数，返回一个具体的具有public属性的方法
            Method method1 = c1.getMethod("testPublicVoidMethod", null);
            Log.e("sheng", "method1 == " + method1);
            Method method2=c1.getMethod("testShowLog",String.class);
            method2.invoke(c1.newInstance(), "test");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //返回所有具有public属性的方法数组
        Method[] methods1 = c1.getMethods();
        for (int i = 0; i < methods1.length; i++) {
            Log.e("sheng", "methods == " + i + "==" + methods1[i]);
        }

        try {
            //根据方法名和参数，返回一个具体的方法（不分public和非public属性）
            Method method2 = c1.getDeclaredMethod("testPublicVoidMethod", null);
            Log.e("sheng", "method2==" + method2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //返回该类中的所有的方法数组（不分public和非public属性）
        Method[] methods2 = c1.getDeclaredMethods();
        for (int i = 0; i < methods2.length; i++) {
            Log.e("sheng", "methods==" + i + "=" + methods2[i]);
        }

    }

    private void showInstance() {
        try {
            Class c1 = Class.forName("com.sheng.reflection.ReflectTest");
            //无参构造创建对象
            ReflectTest r1 = (ReflectTest) c1.newInstance();
            Log.e("sheng",c1.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //有参创建构造函数
            Class c2 = Class.forName("com.sheng.reflection.ReflectTest");
            Constructor constructor = c2.getConstructor(String.class);
            ReflectTest r2 = (ReflectTest) constructor.newInstance("11");
            Log.e("sheng",c2.toString());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private void showConstrucror() {
        Class c1 = ReflectTest.class;
        try {
            // 根据构成函数的参数，返回一个具有public属性的够惨函数
            Constructor constructor1 = c1.getConstructor(String.class);
            Log.e("sheng", "constructor1==" + constructor1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //返回所有具有public属性的构造函数
        Constructor[] constructors1 = c1.getConstructors();
        for (int i = 0; i < constructors1.length; i++) {
            Log.e("sheng", "constructors==" + i + "=" + constructors1[i]);
        }

        try {
            //根据构造函数的参数，返回构造方法，不分public和private
            Constructor constructor2 = c1.getDeclaredConstructor(String.class, String.class);
            Log.e("sheng", "constructor2==" + constructor2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Constructor[] constructors2 = c1.getDeclaredConstructors();
        for (int i = 0; i < constructors2.length; i++) {
            Log.e("sheng", "constructors2==" + i + "=" + constructors2[1]);
        }


    }

    private void showClass() {
        try {
            Class c1 = Class.forName("com.sheng.reflection.ReflectTest");
            Class c2 = ReflectTest.class;
            Class c3 = (new ReflectTest()).getClass();
            Log.e("sheng", "c1===" + c1);
            Log.e("sheng", "c2===" + c2);
            Log.e("sheng", "c3===" + c3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
