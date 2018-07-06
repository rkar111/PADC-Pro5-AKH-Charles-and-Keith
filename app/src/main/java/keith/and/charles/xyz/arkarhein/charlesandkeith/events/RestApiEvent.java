package keith.and.charles.xyz.arkarhein.charlesandkeith.events;

import java.util.List;

import keith.and.charles.xyz.arkarhein.charlesandkeith.data.vo.NewProductVO;

public class RestApiEvent {
    public static class onSuccessDataEvent {
        private String loadedPageIndex;
        private List<NewProductVO> productVOList;

        public onSuccessDataEvent(String loadedPageIndex, List<NewProductVO> productVOS) {
            this.loadedPageIndex = loadedPageIndex;
            this.productVOList = productVOS;
        }

        public String getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<NewProductVO> getProductVOList() {
            return productVOList;
        }
    }
}
