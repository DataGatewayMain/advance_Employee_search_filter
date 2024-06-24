package total.people.dto;

import java.util.List;

import org.springframework.hateoas.EntityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse<T> {

	private List<EntityModel<T>> total_data;
    private PaginationTotal pagination_total;

    public CustomResponse(List<EntityModel<T>> total_data, PaginationTotal pagination_total) {
        this.total_data = total_data;
        this.pagination_total = pagination_total;
    }

    // Getters and setters
    public List<EntityModel<T>> getTotal_data() {
        return total_data;
    }

    public void setTotal_data(List<EntityModel<T>> total_data) {
        this.total_data = total_data;
    }

    public PaginationTotal getPagination_total() {
        return pagination_total;
    }

    public void setPagination_total(PaginationTotal pagination_total) {
        this.pagination_total = pagination_total;
    }

    public static class PaginationTotal {
        private String current_page_total;
        private String total_pages_total;
        private String records_per_page_total;

        public PaginationTotal(String current_page_total, String total_pages_total, String records_per_page_total) {
            this.current_page_total = current_page_total;
            this.total_pages_total = total_pages_total;
            this.records_per_page_total = records_per_page_total;
        }

        // Getters and setters
        public String getCurrent_page_total() {
            return current_page_total;
        }

        public void setCurrent_page_total(String current_page_total) {
            this.current_page_total = current_page_total;
        }

        public String getTotal_pages_total() {
            return total_pages_total;
        }

        public void setTotal_pages_total(String total_pages_total) {
            this.total_pages_total = total_pages_total;
        }

        public String getRecords_per_page_total() {
            return records_per_page_total;
        }

        public void setRecords_per_page_total(String records_per_page_total) {
            this.records_per_page_total = records_per_page_total;
        }
    }
}