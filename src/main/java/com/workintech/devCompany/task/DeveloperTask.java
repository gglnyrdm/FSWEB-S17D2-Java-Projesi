package com.workintech.devCompany.task;

import org.springframework.stereotype.Component;

@Component
public class DeveloperTask implements Taxable{
    @Override
    public double getSimpleTaxRate() {
        return 0.25;
    }

    @Override
    public double getMiddleTaxRate() {
        return 0.27;
    }

    @Override
    public double getUpperTaxRate() {
        return 0.29;
    }
}
