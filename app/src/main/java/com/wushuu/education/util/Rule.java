package com.wushuu.education.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by js on 2016/5/11.
 */
public class Rule {

    private static Rule instance;
    private Map<String, RuleModel> ruleMap;

    private Rule(){
        ruleMap = new HashMap<String, RuleModel>();
        ruleMap.put("1", new RuleModel(1,1,10));
        ruleMap.put("2", new RuleModel(2,2,10));
        ruleMap.put("3", new RuleModel(1,2,10));
        ruleMap.put("4", new RuleModel(3,3,10));
        ruleMap.put("5", new RuleModel(4,4,10));
        ruleMap.put("6", new RuleModel(3,4,10));
        ruleMap.put("7", new RuleModel(5,5,10));
        ruleMap.put("8", new RuleModel(6,6,10));
        ruleMap.put("9", new RuleModel(5,6,10));
        ruleMap.put("10", new RuleModel(1,5,10));
    }
    public static Rule getInstance(){
        if(instance == null){
            instance = new Rule();
        }
        return instance;
    }

    public List<Expression> getPracticeList(String chapter){
        List<Expression> practiceList = new ArrayList<Expression>();
        RuleModel rule = null;
        for(Map.Entry<String, RuleModel> entry : ruleMap.entrySet()){
            if(entry.getKey().equals(chapter)){
                rule = entry.getValue();
            }
        }
        if (rule == null)
            return null;
        for(int i = rule.getBegin(); i <= rule.getEnd(); i++){
            Random random = new Random();
            Expression expression ;
            if(rule.getBegin() == rule.getEnd()){
                for(int j = 1; j <= rule.getLimit()-i; j++){
                    expression = new Expression(String.valueOf(i)+"+"+String.valueOf(j)+"=",i+j);
                    practiceList.add(expression);
//                    practiceList.add(String.valueOf(i)+"+"+String.valueOf(j)+"="+String.valueOf(i+j));
                }
                for(int j = rule.getLimit()-i; j < 20; j++){
                    int randNum = random.nextInt(rule.getLimit()-rule.getBegin())+1;
                    expression = new Expression(String.valueOf(i)+"+"+String.valueOf(randNum)+"=",i+randNum);
                    practiceList.add(expression);
                }
            }else{
                System.out.println("limit="+Math.ceil(20/(rule.getEnd()-rule.getBegin()+1)));
                for(int j = 1; j <= Math.ceil(20/(rule.getEnd()-rule.getBegin()+1)); j++){
                    int randNum = random.nextInt(rule.getLimit()-i)+1;
                    expression = new Expression(String.valueOf(i)+"+"+String.valueOf(randNum)+"=",i+randNum);
                    practiceList.add(expression);
                }
            }

        }
        return practiceList;
    }

}
