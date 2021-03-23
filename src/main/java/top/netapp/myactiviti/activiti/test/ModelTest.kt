package top.netapp.myactiviti.activiti.test

import com.fasterxml.jackson.databind.ObjectMapper
import org.activiti.editor.constants.ModelDataJsonConstants
import org.activiti.engine.ProcessEngines
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/model")
class ModelTest {
    @RequestMapping("/create")
    fun createModel(request: HttpServletRequest, response: HttpServletResponse) {
        try {
            val modelName = "modelName"
            val modelKey = "modelKey"
            val description = "description"
            val processEngine = ProcessEngines.getDefaultProcessEngine()
            val repositoryService = processEngine.repositoryService
            val objectMapper = ObjectMapper()
            val editorNode = objectMapper.createObjectNode()
            editorNode.put("id", "canvas")
            editorNode.put("resourceId", "canvas")
            val stencilSetNode = objectMapper.createObjectNode()
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#")
            editorNode.put("stencilset", stencilSetNode)
            val modelData = repositoryService.newModel()
            val modelObjectNode = objectMapper.createObjectNode()
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, modelName)
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1)
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description)
            modelData.metaInfo = modelObjectNode.toString()
            modelData.name = modelName
            modelData.key = modelKey

            //保存模型
            repositoryService.saveModel(modelData)
            repositoryService.addModelEditorSource(modelData.id, editorNode.toString().toByteArray(charset("utf-8")))
            response.sendRedirect(request.contextPath + "/modeler.html?modelId=" + modelData.id)
        } catch (e: Exception) {
        }
    }
}