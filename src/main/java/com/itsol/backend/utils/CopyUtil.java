package com.itsol.backend.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CopyUtil {
    public static <T> void copyOldToNewModel(T oldModel, T newModel) {
        boolean checkNull = checkModelAllFieldIsNull(newModel);
        if (!checkNull) {
            return;
        }
        Field[] oldFields = oldModel.getClass().getDeclaredFields();
        Field[] newFields = newModel.getClass().getDeclaredFields();

        try {
            for (int i = 0; i < oldFields.length; i++) {
                String name = oldFields[i].getName().substring(0, 1).toUpperCase() + oldFields[i].getName().substring(1);
                String methodGet = "get" + name;
                Method oldMethod = oldModel.getClass().getMethod(methodGet);
                Method newMethod = newModel.getClass().getMethod(methodGet);

                if (newMethod.invoke(newModel) == null && oldMethod.invoke(oldModel) != null) {
                    newFields[i].set(newModel, oldMethod.invoke(oldModel));
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static <T> boolean checkModelAllFieldIsNull(T model) {
        Field[] fields = model.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                String name = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                String methodGet = "get" + name;
                Method method = model.getClass().getMethod(methodGet);
                if (method.invoke(model) != null) {
                    return false;
                }

            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return false;
        }

        return true;
    }
}
