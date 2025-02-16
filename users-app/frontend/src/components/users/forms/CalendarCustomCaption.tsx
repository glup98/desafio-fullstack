import { useNavigation } from 'react-day-picker';
import { format } from 'date-fns';
import { es } from 'date-fns/locale';
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select';
import { Button } from '@/components/ui/button';
import { ChevronLeft, ChevronRight } from 'lucide-react';

export const CalendarCustomCaption = () => {
  const { goToMonth, currentMonth, previousMonth, nextMonth } = useNavigation();
  const currentYear = currentMonth.getFullYear();
  const currentMonthFormatted = format(currentMonth, 'MMMM', { locale: es });

  const years = Array.from({ length: 200 }, (_, i) => currentYear - 100 + i);

  const handleYearChange = (year: string) => {
    const newDate = new Date(currentMonth);
    newDate.setFullYear(parseInt(year));
    goToMonth(newDate);
  };

  return (
    <div className='flex items-center justify-between gap-2'>
      <Button
        variant='ghost'
        size='icon'
        onClick={() => previousMonth && goToMonth(previousMonth)}
        disabled={!previousMonth}
      >
        <ChevronLeft className='h-4 w-4' />
      </Button>

      <div className='flex items-center gap-2'>
        <span className='text-sm font-medium capitalize'>{currentMonthFormatted}</span>
        <Select value={currentYear.toString()} onValueChange={handleYearChange}>
          <SelectTrigger className='w-[100px]'>
            <SelectValue placeholder={currentYear} />
          </SelectTrigger>
          <SelectContent className='h-[200px]'>
            {years.map((year) => (
              <SelectItem key={year} value={year.toString()}>
                {year}
              </SelectItem>
            ))}
          </SelectContent>
        </Select>
      </div>
      <Button
        variant='ghost'
        size='icon'
        onClick={() => nextMonth && goToMonth(nextMonth)}
        disabled={!nextMonth}
      >
        <ChevronRight className='h-4 w-4' />
      </Button>
    </div>
  );
};
