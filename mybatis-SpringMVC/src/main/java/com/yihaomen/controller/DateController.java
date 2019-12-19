package com.yihaomen.controller;

import com.google.common.collect.ImmutableMap;
import com.yihaomen.inter.IUserOperation;
import com.yihaomen.model.Article;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiChannel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.Length;

@RestController
@RequestMapping("/date")
public class DateController {

    @RequestMapping
    public ResponseEntity test(DateTest test) throws IOException {
        System.out.println(test.getDate());
        return ResponseEntity.ok("");
    }

    @RequestMapping(method = RequestMethod.POST)
    public OpPositionVO save(HttpServletRequest httpServletRequest) throws IOException {
        try {
            System.out.println("/paychannel/alipay/ request body: " +
                httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("/paychannel/alipay/ request parameter: " + httpServletRequest.getParameterMap());
        return new OpPositionVO();
    }
    //@InitBinder
    //protected void initBinder(WebDataBinder binder) {
    //    binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
    //        @Override public void setAsText(String value) {
    //            setValue(new Date(Long.valueOf(value)));
    //        }
    //
    //    });
    //}

    public static class DateTest {
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private Date date;

        public DateTest() {
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public DateTest(Date date) {
            this.date = date;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Data
    private static class OpPositionVO {
        Map<String, Object> widget = ImmutableMap.of("a", 2, "c", 3);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int psIndex, int peIndex, int[] inorder, int isIndex, int ieIndex) {
        System.out.println("psIndex:" + psIndex + " peIndex" + peIndex);
        if (psIndex <= peIndex && isIndex <= ieIndex) {

            int i = preorder[psIndex];
            TreeNode root = new TreeNode(i);
            int indexBytarget = findIndexBytarget(inorder, i);
            int leftLength = indexBytarget - isIndex;
            int rightLength = ieIndex - indexBytarget;

            root.left = buildTree(preorder, psIndex + 1, peIndex + leftLength, inorder, isIndex, indexBytarget - 1);
            root.right = buildTree(preorder, peIndex - rightLength - 1, peIndex, inorder, isIndex + 1, ieIndex);

            return root;
        }
        return null;
    }

    public int findIndexBytarget(int[] inorder, int target) {

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public boolean search(int[] nums, int target) {
        //1.找出最小值
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int middle = (start + end) / 2;

            if (nums[middle] > nums[end]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        int roa = start;

        start = 0;
        end = nums.length - 1;

        while (start < end) {
            int m = (start + end) / 2;
            int middle = (m + roa) % nums.length;
            if (nums[middle] == target) {
                return true;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Thread th = Thread.currentThread();
        while (true) {
            if (th.isInterrupted()) {
                break;
            }
            // 省略业务代码无数
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}