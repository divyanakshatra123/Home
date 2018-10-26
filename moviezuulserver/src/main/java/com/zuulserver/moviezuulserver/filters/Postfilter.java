package com.zuulserver.moviezuulserver.filters;

import com.netflix.zuul.ZuulFilter;

public class Postfilter extends ZuulFilter {

        @Override
        public String filterType() {
            return "post";
        }

        @Override
        public int filterOrder() {
            return 1;
        }

        @Override
        public boolean shouldFilter() {
            return true;
        }

        @Override
        public Object run() {
            System.out.println("Inside Response Filter");

            return null;
        }
    }

