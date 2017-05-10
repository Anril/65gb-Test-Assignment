package com.anril.domain.usecases;

import com.anril.domain.sources.App65DataSource;

/**
 * Created by Anril on 06.05.2017.
 */

public class FetchData {

    private App65DataSource app65DataSource;

    public FetchData(App65DataSource app65DataSource) {
        this.app65DataSource = app65DataSource;
    }

    public void execute() {
        app65DataSource.fetchData();
    }

}
