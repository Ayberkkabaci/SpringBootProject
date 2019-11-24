package com.example.issue.Util;

import com.example.issue.entity.Issue;

public final class ApiPaths {
    private static final String BASE_PATH="/api";

    public static final class IssueCtrl{
        public static final String CTRL=BASE_PATH+"/issue";
    }
    public static final class ProjectCtrl{
        public static final String CTRL=BASE_PATH+"/project";
    }
}
