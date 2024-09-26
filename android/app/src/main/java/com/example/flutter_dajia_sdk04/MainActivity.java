package com.example.flutter_dajia_sdk04;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.GsonUtils;
import com.innovation.animal.breedfunctionsdk.SDK;
import com.innovation.animal.breedfunctionsdk.bean.InsuredEntranceBean;
import com.innovation.animal.breedfunctionsdk.callback.BusinessListener;
import com.innovation.animal.breedfunctionsdk.callback.LoadingListener;
import com.innovation.animal.breedfunctionsdk.callback.MessageListener;
import com.innovation.animal.breedfunctionsdk.utils.DialogUtil;
import com.innovation.animal.breedfunctionsdk.utils.ToastUtils;
import com.innovation.animal.breedfunctionsdk.widget.LoadingView;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {


    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        /**
         *  业务回调
         */
        SDK.setBusinessListener(new BusinessListener() {


            @Override
            public void onSendInsureResult(String insureId, String enId) {
                ToastUtils.success("回调-推送承保成功-" + insureId + "-" + enId);
            }

            @Override
            public void onSendCasesResult(String caseId) {
                ToastUtils.success("推送长重查勘成功-" + caseId);

            }

            @Override
            public void onScanFaceResult(String caseId) {
                ToastUtils.success("推送脸部查勘成功-" + caseId);
            }


        });
        SDK.setMessageListener(new MessageListener() {
            @Override
            public void showMessage(String msg) {
                super.showMessage(msg);
                ToastUtils.error(msg);
            }

            @Override
            public void showErrorMessage(String msg) {
                super.showErrorMessage(msg);
                ToastUtils.error(msg);
            }
        });
        SDK.setLoadingListener(new LoadingListener() {
            @Override
            public void showLoading() {
                DialogUtil.getInstance().show(MainActivity.this, new LoadingView(MainActivity.this));
            }

            @Override
            public void hideLoading() {
                DialogUtil.getInstance().dismiss();
            }
        });
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.flutter.guide.MethodChannel").setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
                switch (call.method) {

                    case "insureStartPoint":
                        SDK.insuredEntrance(GsonUtils.fromJson(
//                                "{" +
//                                        "    \"deptCode\": \"COMP20230209HBSFGS/29\",\n" +
//                                        "    \"deptName\": \"大家财产保险/大家财产保险有限责任公司新疆分公司\",\n" +
//                                        "    \"insuranceId\": \"DAIDQOFWtf000000000715\",\n" +
//                                        "    \"insuranceName\": \"能繁母猪养殖保险\",\n" +
//                                        "    \"standardInspectionWay\": \"11\",\n" +
//                                        "    \"riskCode\": \"3220\",\n" +
//                                        "    \"riskName\": \"能繁母猪养殖保险\",\n" +
//                                        "    \"clauseCode\": \"322005\",\n" +
//                                        "    \"clauseName\": \"新疆中央财政补贴能繁母猪养殖保险条款\",\n" +
//                                        "    \"animalType\": \"1\",\n" +
//                                        "    \"insuranceMethod\": \"1\",\n" +
//                                        "    \"enterprisesId\": \"441581199807163134\",\n" +
//                                        "    \"enterprisesNames\": \"呃呃呃\",\n" +
//                                        "    \"enId\": \"441581199807163134\",\n" +
//                                        "    \"enName\": \"呃呃呃\",\n" +
//                                        "    \"breedMethod\": \"1\",\n" +
//                                        "    \"createUserId\": \"129001493\",\n" +
//                                        "    \"createUserName\": \"新疆农网1\",\n" +
//                                        "    \"province\": \"广东省\",\n" +
//                                        "    \"city\": \"深圳市\",\n" +
//                                        "    \"county\": \"南山区\",\n" +
//                                        "    \"town\": \"广东省\",\n" +
//                                        "    \"village\": \"\",\n" +
//                                        "    \"address\": \"南头街道深南大道10138号深圳市规划和自然资源局南山管理局\",\n" +
//                                        "    \"insureValidate\": \"1\",\n" +
//                                        "    \"livestockBreeds\": 204,\n" +
//                                        "    \"longitude\": \"116.4148720000000000\",\n" +
//                                        "    \"latitude\": \"40.0398630000000000\"\n" +
//                                        "}"
                                "{\n" +
                                        "    \"deptCode\": \"COMP20230209HBSFGS/1267\",\n" +
                                        "    \"deptName\": \"大家财产保险/大家财产保险有限责任公司辽阳中心支公司\",\n" +
                                        "    \"insuranceId\": \"2024AIwvAE6T000000000174\",\n" +
                                        "    \"insuranceName\": \"商业性育肥猪医疗养殖保险\",\n" +
                                        "    \"standardInspectionWay\": \"12\",\n" +
                                        "    \"riskCode\": \"320D\",\n" +
                                        "    \"riskName\": \"商业性育肥猪医疗养殖保险\",\n" +
                                        "    \"clauseCode\": \"320002\",\n" +
                                        "    \"clauseName\": \"辽宁商业性牲畜医疗养殖保险条款\",\n" +
                                        "    \"animalType\": \"1\",\n" +
                                        "    \"livestockBreeds\": \"203\",\n" +
                                        "    \"insuranceMethod\": \"1\",\n" +
                                        "    \"enterprisesId\": \"110101200004010809\",\n" +
                                        "    \"enterprisesNames\": \"生产验证点数功能\",\n" +
                                        "    \"enId\": \"110101200004010809\",\n" +
                                        "    \"enName\": \"生产验证点数功能\",\n" +
                                        "    \"breedMethod\": \"1\",\n" +
                                        "    \"createUserId\": \"112016447\",\n" +
                                        "    \"createUserName\": \"新疆农网1\",\n" +
                                        "    \"province\": \"广东省\",\n" +
                                        "    \"city\": \"深圳市\",\n" +
                                        "    \"county\": \"南山区\",\n" +
                                        "    \"town\": \"\",\n" +
                                        "    \"village\": \"\",\n" +
                                        "    \"address\": \"广东省深圳市南山区南头街道深南大道1110号桔子水晶深圳南山新豪方酒店\",\n" +
                                        "    \"insureValidate\": \"1\",\n" +
                                        "    \"longitude\": 113.926331,\n" +
                                        "    \"latitude\": 22.541253\n" +
                                        "}"
                                , InsuredEntranceBean.class), MainActivity.this);
                        result.success("Android " + android.os.Build.VERSION.RELEASE);
                        break;
                    case "insureStart":
                        SDK.insuredEntrance(GsonUtils.fromJson(
                                "{" +
                                        "    \"deptCode\": \"COMP20230209HBSFGS/29\",\n" +
                                        "    \"deptName\": \"大家财产保险/大家财产保险有限责任公司新疆分公司\",\n" +
                                        "    \"insuranceId\": \"DAID5nIJHd000000000716\",\n" +
                                        "    \"insuranceName\": \"奶牛养殖保险\",\n" +
                                        "    \"standardInspectionWay\": \"13\",\n" +
                                        "    \"riskCode\": \"3202\",\n" +
                                        "    \"riskName\": \"奶牛养殖保险\",\n" +
                                        "    \"clauseCode\": \"320204\",\n" +
                                        "    \"clauseName\": \"新疆奶牛养殖保险条款\",\n" +
                                        "    \"animalType\": \"2\",\n" +
                                        "    \"livestockBreeds\": \"00\",\n" +
                                        "    \"insuranceMethod\": \"1\",\n" +
                                        "    \"enterprisesId\": \"441581199807163134\",\n" +
                                        "    \"enterprisesNames\": \"畜脸\",\n" +
                                        "    \"enId\": \"441581199807163134\",\n" +
                                        "    \"enName\": \"畜脸\",\n" +
                                        "    \"breedMethod\": \"1\",\n" +
                                        "    \"createUserId\": \"129001493\",\n" +
                                        "    \"createUserName\": \"新疆农网1\",\n" +
                                        "    \"province\": \"广东省\",\n" +
                                        "    \"city\": \"深圳市\",\n" +
                                        "    \"county\": \"南山区\",\n" +
                                        "    \"town\": \"广东省\",\n" +
                                        "    \"village\": \"\",\n" +
                                        "    \"address\": \"南头街道艺园路佳嘉豪商务大厦\",\n" +
                                        "    \"insureValidate\": \"1\",\n" +
                                        "    \"longitude\": \"116.4148720000000000\",\n" +
                                        "    \"latitude\": \"40.0398630000000000\"\n" +
                                        "}"
                                , InsuredEntranceBean.class), MainActivity.this);
                        result.success("Android " + android.os.Build.VERSION.RELEASE);
                        break;
                }
            }
        });
    }
}
